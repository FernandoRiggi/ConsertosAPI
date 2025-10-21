CREATE TABLE conserto (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          data_entrada VARCHAR(10) NOT NULL,
                          data_saida VARCHAR(10),

                          mecanico_nome VARCHAR(100) NOT NULL,
                          mecanico_anos_experiencia INT,

                          veiculo_marca VARCHAR(100) NOT NULL,
                          veiculo_modelo VARCHAR(100) NOT NULL,
                          veiculo_ano VARCHAR(4) NOT NULL,

                          PRIMARY KEY(id)
);