package model;

import java.util.Date;
import java.util.GregorianCalendar;
import lombok.Data;

@Data

public class Cliente {
    private int IDCLI;
    private String NOMCLI;
    private String APECLI;
    private String DNICLI;
    private String TELCLI;
    private String EMACLI;
    private String ESTCLI;
    private Date FECNAC = GregorianCalendar.getInstance().getTime();
    private String DOMCLI;
}
