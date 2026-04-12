import com.task.array.parser.DataParserimpl;
import com.task.array.service.impl.CustomArrayServiceImpl;
import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayExeption;
import com.task.array.reader.Reader;
import com.task.array.validator.DataValidator;
import com.task.array.parser.DataParser;

import java.util.logging.Logger;
import java.util.List;


private static final Logger log = Logger.getLogger(CustomArrayServiceImpl.class.getName());

public static void main(String[] args) {

    String filePath = "data/arrays.txt";

    Reader reader = new Reader();
    DataValidator validator = new DataValidator();
    DataParser parser = new DataParserimpl();
    CustomArrayServiceImpl service = new CustomArrayServiceImpl();

    try {

        List<String> lines = reader.readLines(filePath);

        for (String line : lines) {

            if (validator.isValid(line)) {


                int[] numbers = parser.parseLine(line);


                CustomArray array = CustomArray.createWithData(numbers);


                int max = service.findMax(array);
                log.info("Обработан массив из файла. Max: " + max);

            } else {
                log.warning("Строка пропущена (некорректный формат): " + line);
            }
        }

    } catch (CustomArrayExeption e) {
        log.severe("Ошибка при работе с данными: " + e.getMessage());
    }
}
