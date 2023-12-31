package com.isep.acme.model;

import javax.persistence.*;
import java.util.Objects;

public abstract class Rating {


    public abstract Double getRate() ;

    public abstract void setRate(Double rate) ;
}
