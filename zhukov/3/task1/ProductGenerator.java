package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public  class ProductGenerator {

    private static String[] library = {
            "Болт оцинкованный М8х80 (50шт. уп.)",
            "Бумага наждачная шлифовальная М40 (нулёвка) 1 п.м.",
            "Арматура 8мм А3 (1п.м.)",
            "Гайка М6 шестигранная оцинкованная (450шт.уп.)",
            "Гвозди строительные 3x70мм",
            "Гофра к унитазу 1м.",
            "Грунт-эмаль по ржавчине (3 в 1) Синяя, ведро 20кг",
            "Кирпич лицевой одинарный (размер 250х120х65) М150 цвет абрикос",
            "Кирпич строительный двойной щелевой М150 ( 250х120х130мм)",
            "Клей монтажный КНАУФ Перлфикс / KNAUF Perlfix 30 кг.",
            "Клейкая лента фольгированная алюминиевая",
            "КНАУФ Тифенгрунд / KNAUF Tiefengrund грунтовка универсальная (10 л)",
            "Коллектор с вентильными кранами (Comisa) 3\4-1\2, 4 выхода (88.20.060)",
            "Кран шаровой ф50 (4SPK0766)",
            "Миксер(Мешалка) для смешивания смесей 100*500",
            "Пена монтажная Титан для блоков 750 мл.",
            "ПЕНОПЛЭКС КРОВЛЯ (пл.35 ) 1200х600х50мм 5,76 м2; 0,288 м3, (8 шт) ",
            "Перфоратор Макита HR2450 780 Вт.",
            "ПЕРЧАТКИ рабочие трикотажные с точечным покрытием",
            "Просечка ЦПВС штукатурная, размер 1х10м (10м2)",
            "Радиатор биметаллический XTREME 500*100 (12секций) Италия",
            "Саморезы по дереву 3.8х55",
            "Саморезы с прессшайбой 4,2 х 16 острый наконечник",
            "Тачка строительная 2 колесная 110л",
            "ТИККУРИЛА Евро 2 / TIKKURILA Euro 2 краска матовая латексная (9 л)",
            "Уголок металлический 32 мм (1 п.м.)",
            "Утеплитель Роквул (Rockwool) Лайт Баттс Скандик 5,76м2 (0.288м3) 800*600*50мм",
            "Фильтр промывной для холодной воды с регулятором давления Honeywell FK06-3\4AA(100мк.)",
            "ХЕБЕЛЬ / HEBEL пеноблок 250х600 толщина 100 мм",
            "ЦЕРЕЗИТ СТ 17 / CERESIT CT 17 грунт универсальный (10 л)"
    };

    static public String getRandProduct()
    {
        int index = ThreadLocalRandom.current().nextInt(0, library.length );
        return library[index];
    }

    static public String[] getRandUniqueProducts(int quantity){

        quantity = Math.abs(quantity);

        if( quantity > library.length){
            quantity = library.length;
            System.out.printf("Только %s товаров есть в наличии на складе \n", quantity);
        }

        List<String> products = new ArrayList<>(quantity);
        int i = 0;

        while(i < quantity){
            String product = getRandProduct();
            if(!products.contains(product)){
                products.add(product) ;
                i++;
            }
        }

        return products.toArray( new String[products.size()] );
    }

}
