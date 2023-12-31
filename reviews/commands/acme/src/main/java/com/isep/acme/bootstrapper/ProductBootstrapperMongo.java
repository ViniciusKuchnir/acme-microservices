package com.isep.acme.bootstrapper;

import com.isep.acme.application.interfaces.repository.ProductRepositoryMongo;
import com.isep.acme.model.Product_Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("bootstrap")
public class ProductBootstrapperMongo implements CommandLineRunner {

    @Autowired
    ProductRepositoryMongo pRepo;

    @Override
    public void run(String... args) throws Exception {
        if (pRepo.findBySku("asd578fgh267").isEmpty()) {
            Product_Mongo p1 = new Product_Mongo("asd578fgh267", "Pen", "very good nice product");
            pRepo.save(p1);
        }
        if (pRepo.findBySku("c1d4e7r8d5f2").isEmpty()) {
            Product_Mongo p2 = new Product_Mongo("c1d4e7r8d5f2", "Pencil", " writes ");
            pRepo.save(p2);
        }
        if (pRepo.findBySku("c4d4f1v2f5v3").isEmpty()) {
            Product_Mongo p3 = new Product_Mongo("c4d4f1v2f5v3", "Rubber", "erases");
            pRepo.save(p3);
        }
        if (pRepo.findBySku("v145dc2365sa").isEmpty()) {
            Product_Mongo p4 = new Product_Mongo("v145dc2365sa", "Wallet", "stores money");
            pRepo.save(p4);
        }
        if (pRepo.findBySku("fg54vc14tr78").isEmpty()) {
            Product_Mongo p5 = new Product_Mongo("fg54vc14tr78", "pencil case", " stores pencils");
            pRepo.save(p5);
        }
        if (pRepo.findBySku("12563dcfvg41").isEmpty()) {
            Product_Mongo p6 = new Product_Mongo("12563dcfvg41", "Glasses case", " stores glasses");
            pRepo.save(p6);
        }
        if (pRepo.findBySku("vcg46578vf32").isEmpty()) {
            Product_Mongo p7 = new Product_Mongo("vcg46578vf32", "tissues", " nose clearing material");
            pRepo.save(p7);
        }
        if (pRepo.findBySku("vgb576hgb675").isEmpty()) {
            Product_Mongo p8 = new Product_Mongo("vgb576hgb675", "mouse pad", " mouse adapted surface");
            pRepo.save(p8);
        }
        if (pRepo.findBySku("unbjh875ujg7").isEmpty()) {
            Product_Mongo p9 = new Product_Mongo("unbjh875ujg7", " mug ", " drink something from it");
            pRepo.save(p9);
        }
        if (pRepo.findBySku("u1f4f5e2d2xw").isEmpty()) {
            Product_Mongo p10 = new Product_Mongo("u1f4f5e2d2xw", " Lamp ", " it lights");
            pRepo.save(p10);
        }
        if (pRepo.findBySku("j85jg76jh845").isEmpty()) {
            Product_Mongo p11 = new Product_Mongo("j85jg76jh845", " Pillow ", " cold both sides");
            pRepo.save(p11);
        }
        if (pRepo.findBySku("g4f7e85f4g54").isEmpty()) {
            Product_Mongo p12 = new Product_Mongo("g4f7e85f4g54", " chair ", " comfortable ");
            pRepo.save(p12);
        }
    }
}
