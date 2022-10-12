package controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;

@Named
@RequestScoped
public class MultiSelectView {

    private List<SelectItem> categories;
    private String selection;

    @PostConstruct
    public void init() {
        categories = new ArrayList<SelectItem>();
        SelectItemGroup autos = new SelectItemGroup("Automóviles");
        SelectItemGroup tv = new SelectItemGroup("Televisores");
        SelectItemGroup celulares = new SelectItemGroup("Celulares");
        SelectItemGroup motos = new SelectItemGroup("Motocicletas");

        SelectItemGroup deportivoauto = new SelectItemGroup("Deportivos");
        SelectItemGroup comercialauto = new SelectItemGroup("Comerciales");
        SelectItemGroup celulareshuawei = new SelectItemGroup("Huawei");
        SelectItemGroup celularessamsung = new SelectItemGroup("Samnsung");
        SelectItemGroup celularesmapple = new SelectItemGroup("Apple");

        SelectItemGroup lgtv = new SelectItemGroup("LG");
        SelectItemGroup sonytv = new SelectItemGroup("Sony");

        SelectItem option31 = new SelectItem("Samnsung" + " " + "S22 Ultra");
        SelectItem option32 = new SelectItem("Samnsung" + " " + "A53 5G");
        SelectItem option33 = new SelectItem("Samnsung" + " " + "S22");
        SelectItem option34 = new SelectItem("Samnsung" + " " + "S21 Ultra");
        celularessamsung.setSelectItems(new SelectItem[]{option31, option32, option33, option34});

        SelectItem option35 = new SelectItem("Huawei" + " " + "P40");
        SelectItem option36 = new SelectItem("Huawei" + " " + "P50");
        SelectItem option37 = new SelectItem("Huawei" + " " + "P30 Smart");
        SelectItem option38 = new SelectItem("Huawei" + " " + "Mate 40 Pro");
        celulareshuawei.setSelectItems(new SelectItem[]{option35, option36, option37, option38});

        SelectItem option39 = new SelectItem("Apple" + ", " + "iPhone 13");
        SelectItem option310 = new SelectItem("Apple" + ", " + "iPhone 13 Pro Max");
        SelectItem option311 = new SelectItem("Apple" + ", " + "iPhone 14");
        SelectItem option312 = new SelectItem("Apple" + ", " + "iPhone 14 Pro Max");
        celularesmapple.setSelectItems(new SelectItem[]{option39, option310, option311, option312});

        SelectItem option41 = new SelectItem("Motos" + " " + "NAKED");
        SelectItem option42 = new SelectItem("Motos" + " " + "TRIAL");
        SelectItem option43 = new SelectItem("Motos" + " " + "MEGASCOOTER");
        SelectItem option44 = new SelectItem("Motos" + " " + "SCOOTER");

        SelectItem option111 = new SelectItem("Ferrari 250 GTO");
        SelectItem option112 = new SelectItem("Lamborghini");
        SelectItem option113 = new SelectItem("Porsche 959");
        SelectItem option114 = new SelectItem("Ford Mustang");
        deportivoauto.setSelectItems(new SelectItem[]{option111, option112, option113, option114});

        SelectItem option121 = new SelectItem("Nissan" + " " + "Versa");
        SelectItem option122 = new SelectItem("Toyota" + " " + "GAZOO");
        SelectItem option123 = new SelectItem("Mercedes" + " " + "Benz");
        comercialauto.setSelectItems(new SelectItem[]{option121, option122, option123});

        SelectItem option211 = new SelectItem("Lg" + " " + "40' Pulgadas");
        SelectItem option212 = new SelectItem("Lg" + " " + "60' Pulgadas");
        SelectItem option213 = new SelectItem("Lg" + " " + "50' Pulgadas");
        lgtv.setSelectItems(new SelectItem[]{option211, option212, option213});

        SelectItem option214 = new SelectItem("Sony" + " " + "40' Pulgadas");
        SelectItem option215 = new SelectItem("Sony" + " " + "60' Pulgadas");
        SelectItem option216 = new SelectItem("Sony" + " " + "50' Pulgadas");
        sonytv.setSelectItems(new SelectItem[]{option214, option215, option216});

        autos.setSelectItems(new SelectItem[]{deportivoauto, comercialauto});
        tv.setSelectItems(new SelectItem[]{lgtv, sonytv});
        celulares.setSelectItems(new SelectItem[]{celularessamsung, celulareshuawei, celularesmapple});
        motos.setSelectItems(new SelectItem[]{option41, option42, option43, option44});

        categories.add(autos);
        categories.add(tv);
        categories.add(celulares);
        categories.add(motos);
    }

    public List<SelectItem> getCategories() {
        return categories;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }
}
