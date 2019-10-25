package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
    public static String datahoraparaarquivo(){
        Timestamp Ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyhhmmss").format(Ts);
    }



}
