package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 7/7/2016.
 */
public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName.toLowerCase());
    }

    public void testGetColumnsMethod(){
        int nr=EntityUtils.getColumns(Department.class).size();
        assertEquals("Number of columns should be 3", 3, nr);
    }

    public void testCastFromSqlTypeMethod(){
        Object rez1=EntityUtils.castFromSqlType(new BigDecimal(1),Integer.class);
        Object rez2=EntityUtils.castFromSqlType(new BigDecimal(1),Long.class);
        Object rez3=EntityUtils.castFromSqlType(new BigDecimal(1),Float.class);
        Object rez4=EntityUtils.castFromSqlType(new BigDecimal(1),Double.class);
        Object rez5=EntityUtils.castFromSqlType(new Integer(7),Integer.class);

        assertTrue(rez1 instanceof Integer);
        assertTrue(rez2 instanceof Long);
        assertTrue(rez3 instanceof Float);
        assertTrue(rez4 instanceof Double);
        assertTrue(rez5 instanceof Integer);
    }

    public void testGetFieldsByAnnotationsMethod(){
        List<Field> columns=EntityUtils.getFieldsByAnnotations(Location.class, Column.class);
        assertTrue(columns.size()==4);
    }

    public void testGetSqlValueMethod(){
        Department department=new Department();
        department.setId(1);
        try {
            Object rez = EntityUtils.getSqlValue(department);
            assertTrue(rez instanceof Long && (Long) rez==1);
        }catch(Exception e){
            System.out.println("exceptie");
        }
    }
}
