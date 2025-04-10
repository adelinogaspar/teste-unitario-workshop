-- Inserindo alunos (mutantes)
INSERT INTO aluno (id, nome_real, nome_fantasia, forca, inteligencia, data_cadastro) VALUES
('1', 'Charles Francis Xavier', 'Professor X', 50, 1000, '1963-09-01'),
('2', 'James Howlett', 'Logan', 900, 300, '1970-05-01'),
('3', 'Ororo Munroe', 'Tempestade', 600, 700, '1980-06-15'),
('4', 'Jean Elaine Grey', 'Jean Grey', 500, 900, '1986-11-02'),
('5', 'Scott Summers', 'Ciclope', 700, 600, '1983-07-10'),
('6', 'Kurt Wagner', 'Noturno', 400, 500, '1985-03-18'),
('7', 'Raven Darkhölme', 'Mística', 450, 800, '1970-12-05');

-- Inserindo habilidades (mutantes têm muitas!)
INSERT INTO habilidade (id, tipo, descricao) VALUES
('101', 'Telepatia', 'Capacidade de ler e controlar mentes.'),
('102', 'Fator de Cura', 'Regeneração acelerada e envelhecimento lento.'),
('103', 'Manipulação do Clima', 'Capacidade de controlar o clima e gerar tempestades.'),
('104', 'Telecinese', 'Movimentação de objetos com a mente.'),
('105', 'Explosão Óptica', 'Disparo de rajadas de energia pelos olhos.'),
('106', 'Teletransporte', 'Movimentação instantânea para qualquer lugar visível.'),
('107', 'Metamorfose', 'Habilidade de alterar aparência e voz.');

-- Associando alunos às suas habilidades
INSERT INTO habilidades_aluno (id_aluno, id_habilidade) VALUES
('1', '101'), -- Charles Xavier - Telepatia
('2', '102'), -- Logan - Fator de Cura
('3', '103'), -- Ororo - Manipulação do Clima
('4', '104'), -- Jean Grey - Telecinese
('5', '105'), -- Scott Summers - Explosão Óptica
('6', '106'), -- Noturno - Teletransporte
('7', '107'); -- Mística - Metamorfose

-- Adicionando habilidades extras para alguns personagens
INSERT INTO habilidades_aluno (id_aluno, id_habilidade) VALUES
('4', '101'), -- Jean Grey também tem telepatia
('2', '104'), -- Logan tem resistência telecinética (não é afetado facilmente)
('7', '101'); -- Mística pode resistir à telepatia em alguns casos