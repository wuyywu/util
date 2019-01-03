几个概念

　　　　P： 为Producer，数据的发送方。

　　　　C：为Consumer，数据的接收方。

　　　　Exchange：消息交换机，它指定消息按什么规则，路由到哪个队列。

　　　　Queue：消息队列载体，每个消息都会被投入到一个或多个队列。

　　　　Binding：绑定，它的作用就是把exchange和queue按照路由规则绑定起来。

　　　　Routing Key：路由关键字，exchange根据这个关键字进行消息投递。

　　　　vhost：虚拟主机，一个broker里可以开设多个vhost，用作不同用户的权限分离。

　　　　channel：消息通道，在客户端的每个连接里，可建立多个channel，每个channel代表一个会话任务。

安装：
https://www.cnblogs.com/zhangweizhong/p/5689209.html
如果安装rabbitMQ首先安装基于erlang语言支持的OTP软件，然后在下载rabbitMQ软件进行安装

问题：
1：如果消费者连接中断，这期间我们应该怎么办

2：如何做到负载均衡

3：如何有效的将数据发送到相关的接收者？就是怎么样过滤

4：如何保证消费者收到完整正确的数据

5：如何让优先级高的接收者先收到数据