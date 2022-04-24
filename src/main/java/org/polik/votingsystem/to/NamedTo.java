package org.polik.votingsystem.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by Polik on 4/15/2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class NamedTo extends BaseTo {
    @NotBlank
    @Size(min = 2, max = 100, message = "length must be between 4 and 50 characters")
    protected String name;

    public NamedTo() {
    }

    protected NamedTo(Integer id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '[' + name + ']';
    }
}
