package com.spring.boot.all.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(name="name", column = @Column(name = "guardian_name")),
        @AttributeOverride(name="mobile", column = @Column(name = "guardian_mobile"))
})
public class Guardian {
    private String name;
    private Long mobile;
}
