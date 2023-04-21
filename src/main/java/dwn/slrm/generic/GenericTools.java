package dwn.slrm.generic;

import dwn.slrm.business.exceptions.ReflexionException;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericTools {
    public static <T> T callGenericConstructor(Class<?> clazz, int genericInterfacePosition, int genericClassPosition) {
        try {
            // IAbstractCrudService<ActualEntityType,ActualDtoType>
            ParameterizedType genericInterface = (ParameterizedType) clazz.getGenericInterfaces()[genericInterfacePosition];
            // ActualEntityType
            Type actualTypeArguments = genericInterface.getActualTypeArguments()[genericClassPosition];
            // Default Constructor for ActualEntityType
            Constructor<?> entityConstructor = Class.forName(actualTypeArguments.getTypeName()).getDeclaredConstructor();
            // Cast new Object
            Object newObject = entityConstructor.newInstance();
            return (T) newObject;
        } catch (Exception e) {
            throw new ReflexionException(e.getMessage());
        }
    }
}
