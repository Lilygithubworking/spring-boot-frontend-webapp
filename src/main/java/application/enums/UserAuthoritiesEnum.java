package application.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mj on 2/6/16.
 */
public enum UserAuthoritiesEnum {
    ADMIN(1, "ROLE_ADMIN"),

    USER(2, "ROLE_USER");


    public int id() {
        return id;
    }

    public String description() {
        return description;
    }

    private int id;
    private String description;

    private UserAuthoritiesEnum(int id, String description) {
        this.id = id;
        this.description = description;
    }

    private static final Map<Integer, UserAuthoritiesEnum> statuses = new HashMap<Integer, UserAuthoritiesEnum>();

    static {
        for (UserAuthoritiesEnum status : UserAuthoritiesEnum.values()) {
            if (statuses.get(status.id) == null) {
                statuses.put(status.id, status);
            } else {
                // throw new BadPracticeException("Duplicate id: " + status.id);
            }
        }
    }

    public static UserAuthoritiesEnum valueOf(int id) {
        return statuses.get(id);
    }
}
