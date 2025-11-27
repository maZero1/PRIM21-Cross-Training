
-- INSERIR ALUNO
INSERT INTO ALUNO (id, nome, telefone, email, data_cadastro, status)
VALUES (1, 'João Silva', '999999999', 'joao@gmail.com', CURRENT_DATE, 'ATIVO');

-- INSERIR MENSALIDADE
INSERT INTO MENSALIDADE (id, mes_referencia, data_vencimento, valor, status_pagamento)
VALUES (1, 'Novembro/2024', CURRENT_DATE, 120.0, 'PENDENTE');


-- INSERIR HORÁRIO
INSERT INTO HORARIO (id, dia_semana, hora_inicio, hora_fim, descricao)
VALUES (1, 'SEGUNDA', '08:00:00', '09:00:00', 'Treino funcional');

-- INSERIR MATRÍCULA
INSERT INTO MATRICULA_HORARIO (id, data_inicio, situacao)
VALUES (1, CURRENT_DATE, 'ATIVA');

-- INSERIR REPOSIÇÃO
INSERT INTO REPOSICAO_AULA (id, data_original, motivo, status)
VALUES (1, CURRENT_DATE, 'Doença', 'SOLICITADA');

-- ASSOCIAÇÕES UNIDIRECIONAIS (DO ALUNO → OUTRAS ENTIDADES)

INSERT INTO ALUNO_MENSALIDADES (aluno_id, mensalidades_id)
VALUES (1, 1);

INSERT INTO ALUNO_MATRICULAS (aluno_id, matriculas_id)
VALUES (1, 1);

INSERT INTO ALUNO_REPOSICOES (aluno_id, reposicoes_id)
VALUES (1, 1);
