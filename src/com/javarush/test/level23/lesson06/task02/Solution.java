package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.Server_is_not_accessible_for_now);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.Server_is_not_accessible_for_now, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.User_is_not_authorized);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.User_is_not_authorized, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.User_is_banned);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.User_is_banned, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.Access_is_denied);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.Access_is_denied, cause);
        }
    }

    public final static class Constants{
        private final static String Server_is_not_accessible_for_now="Server is not accessible for now.";
        private final static String User_is_not_authorized="User is not authorized.";
        private final static String User_is_banned="User is banned.";
        private final static String Access_is_denied="Access is denied.";
    }
}
