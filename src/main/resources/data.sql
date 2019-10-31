INSERT INTO cargos (id, descricao) VALUES
  ((select SEQ_CARGO.nextval from dual),  'Gerente'),
  ((select SEQ_CARGO.nextval from dual),'Administrador');
INSERT INTO perfis (id, descricao) VALUES
  ((select SEQ_PERFIL.nextval from dual),  'Administrador'),
  ((select SEQ_PERFIL.nextval from dual),'Comum');  
  INSERT INTO status (id, descricao) VALUES
  ((select SEQ_STATUS.nextval from dual),  'ATIVO'),
  ((select SEQ_STATUS.nextval from dual),'INATIVO');
INSERT INTO usuarios (id, nome, cpf, sexo, data_nascimento, cargo, perfil, status) VALUES
  ((select SEQ_USUARIO.nextval from dual),  'Joao Silva', '23168796085', 'M', '1970-01-01', 1,1, 1),
  ((select SEQ_USUARIO.nextval from dual),'Maria Santos', '04612723007', 'F', '1970-01-01', 2,2,1);
