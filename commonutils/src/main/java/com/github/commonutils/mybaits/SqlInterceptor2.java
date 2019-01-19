package com.github.commonutils.mybaits;

import com.github.commonutils.util.SqlUtils;
import com.github.commonutils.util.StringUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

/**
 * 打印sql
 *
 * @author wuyun
 * @date 2019/1/14 20:13
 */
@Component
@Profile({"dev", "test"})
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})}
)
public class SqlInterceptor2 implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object result = null;
        //捕获掉异常，不要影响业务
        try {
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            Object parameter = null;
            if (invocation.getArgs().length > 1) {
                parameter = invocation.getArgs()[1];
            }
            String sqlId = mappedStatement.getId();
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);
            Configuration configuration = mappedStatement.getConfiguration();

            long startTime = System.currentTimeMillis();

            try {
                result = invocation.proceed();
            } finally {
                long endTime = System.currentTimeMillis();
                long sqlCostTime = endTime - startTime;
                String sql = this.getSql(configuration, boundSql);
                this.formatSqlLog(mappedStatement.getSqlCommandType(), sqlId, sql, sqlCostTime, result);
            }
            return result;

        } catch (Exception e) {
            return result;
        }
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {
    }

    /**
     * 获取完整的sql语句
     *
     * @param configuration
     * @param boundSql
     * @return
     */
    private String getSql(Configuration configuration, BoundSql boundSql) {
        // 输入sql字符串空判断
        String sql = boundSql.getSql();
        if (StringUtils.isEmpty(sql)) {
            return "";
        }

        //美化sql
        sql = SqlUtils.beautifySql(sql);

        //填充占位符, 目前基本不用mybatis存储过程调用,故此处不做考虑
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        sql = SqlUtils.formatSql(sql, parameterObject, parameterMappings);

        return sql;
    }

    /**
     * 格式化sql日志
     *
     * @param sqlCommandType
     * @param sqlId
     * @param sql
     * @param costTime
     * @return
     */
    private void formatSqlLog(SqlCommandType sqlCommandType, String sqlId, String sql, long costTime, Object obj) {
        String sqlLog = "==> " + sql;
        StringBuffer result = new StringBuffer();
        if (obj instanceof List){
            List list = (List) obj;
            int count = list.size();
            result.append("<==      Total: " + count);
        }else if (obj instanceof Integer){
            result.append("<==      Total: " + obj);
        }

        result.append("      Spend Time ==> " + costTime + " ms");
        Logger log = LoggerFactory.getLogger(sqlId);
        log.info(sqlLog);
        log.info(result.toString());
    }
}


