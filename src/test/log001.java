package test;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by maxim on 08.07.2015.
 */
public class log001 {
    /**
     * Старт программы
     * @param args не используется
     */
    public static void main(String[] args)
    {
        // Получаем экземпляр класса, который будем использовать для записи логов.
        // Передаваемый параметр log001 - имя логера.
        // В документации сказано, что имя логгера должно совпадать с именем
        // класса или пакета ().
        Logger logger = Logger.getLogger(log001.class.getName());


        // Создаём handler, который будет записывать лог
        // в файл "log001". Символ "%t" указывает на то, что файл
        // будет располагаться в папке с системными временными файлами.
        try {
            //FileHandler fh = new FileHandler("%tLogApp");
            FileHandler fh = new FileHandler("D:/TEMP/111.txt");
            logger.addHandler(fh);

            // Добавляем ещё файл "LogApp.htm".
            log002 htmlformatter = new log002();
            FileHandler htmlfile = new FileHandler("D:/TEMP/222.html");
            // Устанавливаем html форматирование с помощью класса HtmlFormatter.
            htmlfile.setFormatter(htmlformatter);
            logger.addHandler(htmlfile);

        } catch (SecurityException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за политики безопасности.",
                    e);
        } catch (IOException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за ошибки ввода-вывода.",
                    e);
        }

        logger.log(Level.INFO, "Запись лога с уровнем INFO (информационная)");
        logger.log(Level.WARNING,"Запись лога с уровнем WARNING (Предупреждение)");
        logger.log(Level.SEVERE, "Запись лога с уровнем SEVERE (серъёзная ошибка)");
    }
}