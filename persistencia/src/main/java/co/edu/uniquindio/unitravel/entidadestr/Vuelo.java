package co.edu.uniquindio.unitravel.entidadestr;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Vuelo implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(length = 20, nullable = false)
    private String estado;
    @Column(length = 30, nullable = false)
    private String aerolinea;
    @ManyToOne
    private Ciudad ciudad;
    @OneToMany(mappedBy = "vuelo")
    private List<Silla> sillas;

}
