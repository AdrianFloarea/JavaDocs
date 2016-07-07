package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/7/2016.
 */
public class EntityUtils {

    private EntityUtils() throws UnsupportedOperationException{}

    public static String getTableName(Class entity){
        Table table=(Table)entity.getAnnotation(Table.class);
        if(table==null){return entity.getName();}
        else{
            return table.name();
        }
    }

    public static List<ColumnInfo> getColumns(Class entity){
        Field[] fields=entity.getFields();
        List<ColumnInfo> columnInfoList=new ArrayList<>();
        for(Field f:fields){
            ColumnInfo columnInfo=new ColumnInfo();
            if(f.isAnnotationPresent(Id.class)){
                columnInfo.setId(true);
                Id id=(Id)f.getAnnotation(Id.class);
                columnInfo.setDbName(id.name());
            }else{
                columnInfo.setId(false);
                Column column=(Column)f.getAnnotation(Column.class);
                columnInfo.setDbName(column.name());
            }
            columnInfo.setColumnName(f.getName());
            columnInfo.setColumnType(f.getType());
            columnInfoList.add(columnInfo);
        }
        return columnInfoList;
    }

    public static Object castFromSqlType(Object value, Class wantedType){
        if(value instanceof BigDecimal){
            if(wantedType.equals(Integer.class)){return (Integer)value;}
            if(wantedType.equals(Long.class)){return (Long)value;}
            if(wantedType.equals(Float.class)){return (Float)value;}
            if(wantedType.equals(Double.class)){return (Double)value;}
        }
        return value;
    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation){
        Field[] fields=clazz.getFields();
        List<Field> result=new ArrayList<>();
        for(Field f:fields){
            if(f.isAnnotationPresent(annotation)){
                result.add(f);
            }
        }
        return result;
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {
        if(object.getClass().isAnnotationPresent(Table.class)){
            Field[] fields=object.getClass().getFields();
            Field idField=null;
            for(Field f:fields){
                if(f.isAnnotationPresent(Id.class)){
                    idField=f;
                    break;
                }
            }
            idField.setAccessible(true);
            return idField.get(object);
        }
        return object;
    }
}
