module devminds.tgcontrol.dao{
 requires java.sql;
 requires mysql.connector.j;
    requires javafx.base;

    exports devminds.tgcontrol.objects;
 exports devminds.tgcontrol.dao;
}