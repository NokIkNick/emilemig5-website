package app.controllers;

import app.entities.Item;
import app.persistence.ConnectionPool;
import io.javalin.http.Context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemController {

    public static List<Item> itemList;

    public static List<Item> fillItemList(Context ctx){
        itemList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            itemList.add(new Item(i,"Item "+i, "test", "also test"));
        }
        ctx.attribute("itemlist",itemList);
        ctx.render("index.html");
        return itemList;
    }

    public static List<Item> getAllUsers(ConnectionPool connectionPool) throws Exception
    {
        itemList = new ArrayList<>();
        String sql = "select * from \"user\"";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();

                while (rs.next())
                {
                    String userName = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    Item item = new Item(0, null, null,null);
                    itemList.add(item);
                }
            }
        }
        catch (Exception ex)
        {
            throw new Exception("Could not get users from database");
        }
        return itemList;
    }

}
