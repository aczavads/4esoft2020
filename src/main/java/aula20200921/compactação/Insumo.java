package aula20200921.compactação;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Insumo implements Serializable  {
    private static final long serialVersionUID = -1193117216289434012L;
    // private static final long serialVersionUID = 3147307285321171386L;

    private transient Logger logger = LoggerFactory.getLogger(Insumo.class);
    private String descricao;

    public Insumo(String descricao) {
        logger.info("Criando um insumo...");

        logger.info("Insumo criado!");
    }


}
