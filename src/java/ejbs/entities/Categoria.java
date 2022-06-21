/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tio_hecro
 */
@Entity
@Table(catalog = "ucandb", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByPkCategoria", query = "SELECT c FROM Categoria c WHERE c.pkCategoria = :pkCategoria"),
    @NamedQuery(name = "Categoria.findByDesignacao", query = "SELECT c FROM Categoria c WHERE c.designacao = :designacao")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "pk_categoria", nullable = false, length = 2147483647)
    private String pkCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String designacao;
    @OneToMany(mappedBy = "fkCategoria")
    private List<Categoria> categoriaList;
    @JoinColumn(name = "fk_categoria", referencedColumnName = "pk_categoria")
    @ManyToOne
    private Categoria fkCategoria;

    public Categoria() {
    }

    public Categoria(String pkCategoria) {
        this.pkCategoria = pkCategoria;
    }

    public Categoria(String pkCategoria, String designacao) {
        this.pkCategoria = pkCategoria;
        this.designacao = designacao;
    }

    public String getPkCategoria() {
        return pkCategoria;
    }

    public void setPkCategoria(String pkCategoria) {
        this.pkCategoria = pkCategoria;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public Categoria getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(Categoria fkCategoria) {
        this.fkCategoria = fkCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCategoria != null ? pkCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.pkCategoria == null && other.pkCategoria != null) || (this.pkCategoria != null && !this.pkCategoria.equals(other.pkCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Categoria[ pkCategoria=" + pkCategoria + " ]";
    }
    
}
