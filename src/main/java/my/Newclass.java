package my;

import java.lang.reflect.Field;
import my.exception.NullArgException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Newclass {
    static Logger LOGGER = LoggerFactory.getLogger(Newclass.class.getName());

    public void checkArgsNotNull(Object input) {
        Exception exception = new Exception();
        StackTraceElement[] sTE =  exception.getStackTrace();
        if (input == null) {
            LOGGER.error("Вызван метод {} с параметром, равным null"
                    , sTE[1].getMethodName());
            throw new NullArgException("Argument is null. See logs for details");
        }

        try {
            for (Field f : input.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(input) == null) {
                        LOGGER.error("Вызван метод {} с параметром {}, равным null"
                                , sTE[1].getMethodName(), f.getName());
                        throw new NullArgException("One of arguments is null. See logs for details");
                    }
            }
        }catch (NullArgException | IllegalAccessException e) {
            throw new NullArgException(e.getMessage());
        }catch (RuntimeException e){
            LOGGER.error("Unexpeted exception");
        }

    }

        public static void main(String[] args) {
            Outer outer = new Outer(
                    "",
                    "nonprivateString", true ,null, true);
            Outer.Inner inner = outer.new Inner("inner");
            Outer.Inner innerNull = outer.new Inner(null);

            Outer.Nested nested = new Outer.Nested("nested");
            Outer.Nested nestedNull = new Outer.Nested(null);


            Newclass newclass = new Newclass();
            String str = null;
            newclass.checkArgsNotNull(nestedNull);
        }
}


