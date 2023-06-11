package org.launchcode.techjobs.persistent.models;

import javax.persistence.GenerationType;

public @interface GeneratedValue {
    GenerationType strategy();
}
