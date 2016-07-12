package br.com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;


/**
 *
 * @author barizon
 */
@Entity
@Table(name = "os")
public class Os implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "os_id")
    private Long id;
    
    @Column(name = "os_dataabertura", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAbertura = new Date();
    
    @Column(name = "os_descricaoprob", nullable = false)
    private String descricaoProblema;
    
    @Column(name = "os_prioridade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    
    @Column(name = "os_acao", nullable = false)
    private String acaoRealizada;
    
    @Column(name = "os_datainicioservico", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataInicioServico;
    
    @Column(name = "os_datafimservico", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataFimServico;
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "os",
            orphanRemoval = true)
    private List<OsItem> osItens = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "setor_id", nullable = false)
    private Setor setor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getAcaoRealizada() {
        return acaoRealizada;
    }

    public void setAcaoRealizada(String acaoRealizada) {
        this.acaoRealizada = acaoRealizada;
    }

    public Date getDataInicioServico() {
        return dataInicioServico;
    }

    public void setDataInicioServico(Date dataInicioServico) {
        this.dataInicioServico = dataInicioServico;
    }

    public Date getDataFimServico() {
        return dataFimServico;
    }

    public void setDataFimServico(Date dataFimServico) {
        this.dataFimServico = dataFimServico;
    }

    public List<OsItem> getOsItens() {
        return osItens;
    }

    public void setOsItens(List<OsItem> osItens) {
        this.osItens = osItens;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Os other = (Os) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }
    
    
}
