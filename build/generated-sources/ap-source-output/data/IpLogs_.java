package data;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-24T16:58:01")
@StaticMetamodel(IpLogs.class)
public class IpLogs_ { 

    public static volatile SingularAttribute<IpLogs, String> date;
    public static volatile SingularAttribute<IpLogs, Integer> ipLogsId;
    public static volatile SingularAttribute<IpLogs, Integer> port;
    public static volatile SingularAttribute<IpLogs, String> ip;
    public static volatile SingularAttribute<IpLogs, Integer> serverInfoId;
    public static volatile SingularAttribute<IpLogs, String> time;
    public static volatile SingularAttribute<IpLogs, String> userName;

}