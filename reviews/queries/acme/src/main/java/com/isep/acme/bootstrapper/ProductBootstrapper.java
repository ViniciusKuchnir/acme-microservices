package com.isep.acme.bootstrapper;

import com.isep.acme.model.Product_SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.isep.acme.model.Product;
import com.isep.acme.application.interfaces.repository.ProductRepository;

@Component
//@Profile("bootstrap")
public class ProductBootstrapper implements CommandLineRunner {

    @Autowired
    private ProductRepository pRepo;

    @Override
    public void run(String... args) throws Exception {

        if (pRepo.findBySku("asd578fgh267").isEmpty()) {
            Product_SQL p1 = new Product_SQL("asd578fgh267", "Pen", "very good nice product");
            pRepo.save(p1);
        }
        if (pRepo.findBySku("c1d4e7r8d5f2").isEmpty()) {
            Product_SQL p2 = new Product_SQL("c1d4e7r8d5f2", "Pencil", " writes ");
            pRepo.save(p2);
        }
        if (pRepo.findBySku("c4d4f1v2f5v3").isEmpty()) {
            Product_SQL p3 = new Product_SQL("c4d4f1v2f5v3", "Rubber", "erases");
            pRepo.save(p3);
        }
        if (pRepo.findBySku("v145dc2365sa").isEmpty()) {
            Product_SQL p4 = new Product_SQL("v145dc2365sa", "Wallet", "stores money");
            pRepo.save(p4);
        }
        if (pRepo.findBySku("fg54vc14tr78").isEmpty()) {
            Product_SQL p5 = new Product_SQL("fg54vc14tr78", "pencil case", " stores pencils");
            pRepo.save(p5);
        }
        if (pRepo.findBySku("12563dcfvg41").isEmpty()) {
            Product_SQL p6 = new Product_SQL("12563dcfvg41", "Glasses case", " stores glasses");
            pRepo.save(p6);
        }
        if (pRepo.findBySku("vcg46578vf32").isEmpty()) {
            Product_SQL p7 = new Product_SQL("vcg46578vf32", "tissues", " nose clearing material");
            pRepo.save(p7);
        }
        if (pRepo.findBySku("vgb576hgb675").isEmpty()) {
            Product_SQL p8 = new Product_SQL("vgb576hgb675", "mouse pad", " mouse adapted surface");
            pRepo.save(p8);
        }
        if (pRepo.findBySku("unbjh875ujg7").isEmpty()) {
            Product_SQL p9 = new Product_SQL("unbjh875ujg7", " mug ", " drink something from it");
            pRepo.save(p9);
        }
        if (pRepo.findBySku("u1f4f5e2d2xw").isEmpty()) {
            Product_SQL p10 = new Product_SQL("u1f4f5e2d2xw", " Lamp ", " it lights");
            pRepo.save(p10);
        }
        if (pRepo.findBySku("j85jg76jh845").isEmpty()) {
            Product_SQL p11 = new Product_SQL("j85jg76jh845", " Pillow ", " cold both sides");
            pRepo.save(p11);
        }
        if (pRepo.findBySku("g4f7e85f4g54").isEmpty()) {
            Product_SQL p12 = new Product_SQL("g4f7e85f4g54", " chair ", " comfortable ");
            pRepo.save(p12);
        }
    }
}
