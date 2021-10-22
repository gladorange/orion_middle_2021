

public class FixPriceShop {
    private String[] items = new String[10];
    private final int PRICE_PRODUCT = 49;
    private int aLuckyhour;
    private double aSale = 0.5;


    public FixPriceShop(){
        getCurrentItems();
        getLuckyHour();
    }

    public String[] getItems(){
        return items;
    }

    private void getLuckyHour() {
        aLuckyhour = (int) (Math.random() * 24);
    }

    int checkItemPrice(String item, int hour){
        for (String aItem: items) {
            if(aItem.equals((item))){
                if(hour == aLuckyhour){
                    return (int)(PRICE_PRODUCT * aSale);
                }else{
                    return PRICE_PRODUCT;
                }
            }
        }
        return -1;
    }

    private void getCurrentItems(){
            String[] aAllAssortimentOfStore = new String[] {"Отделение для очков",
                    "Держатель парковочного билета",
                    "Накладки на педали",
                    "Накладки на педали (R-Line)",
                    "Накладка упора для ног",
                    "Защитные пленки для порогов",
                    "Переключатель многофункциональный",
                    "Передний подстаканник",
                    "Задний подстаканник",
                    "Крепление для сумок в багажном отделении",
                    "Пепельница (Hyundai/KIA)",
                    "Мусорное ведро",
                    "Коврик для вещевого отделения(центральной консоли)",
                    "Коврик для вещевого ящика",
                    "Коврик для дверей (слева спереди)",
                    "Коврик для дверей (справа спереди)",
                    "Коврик в нишу подлокотника",
                    "Коврики резиновые передние",
                    "Клипса крепления коврика салона",
                    "Коврики резиновые задние",
                    "Коврики (комплект) (Novline)",
                    "Коврики (комплект) R32",
                    "Коврик багажника (Novline)",
                    "Сетка багажника",
                    "Инструментальный ящик",
                    "Брызговики передние",
                    "Брызговики задние",
                    "Проставка поддомкратного отверстия",
                    "Щётка для удаления снега",
                    "Щётка телескопическая со скребком и водосгоном для удаления снега",
                    "Комплект для ухода за автомобилем",
                    "Ремень держателя огнетушителя и знака аварийной остановки",
                    "Знак аварийной остановки",
                    "Аварийный жилет",
                    "Аптечка",
                    "Трос буксировочный",
                    "Термокружка",
                    "Майка VW Motorsport M",
                    "Брелок для ключей",
                    "Ручка шариковая",
                    "Набор предохранителей основных номиналов",
                    "Значок Golf"
            };

            for(int i = 0; i < items.length; i++) {
                items[i] = aAllAssortimentOfStore[(int) (Math.random() * aAllAssortimentOfStore.length)];
            }
    }

    void buyItem(String item, int hour){
        int counter = 0;
        for (String aItem: items) {
            if(aItem.equals((item))){
                    System.out.println("товар " + item + "продан по цене " + checkItemPrice(item, hour));
                    items = remove(items, counter);
                    return;
            }
            counter++;
        }
        System.out.println("товар не найден");
    }

    private static String[] remove(String[] array, int index) {
        String[] result = new String[array.length - 1];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(array, index + 1, result, index, result.length - index);
        return result;
    }
}
