package br.com.agendamento.servico;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.agendamento.entidade.AgendamentoEmail;
import br.comagendamento.dao.AgendamentoEmailDAO;

@Stateless
public class AgendamentoEmailServico {

	private static final Logger LOGGER = Logger.getLogger(AgendamentoEmailServico.class.getName());

	@Inject
	private AgendamentoEmailDAO dao;

	public List<AgendamentoEmail> listar() {
		return dao.listar();
	}

	public void inserir(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(false);
		dao.inserir(agendamentoEmail);
	}

	public List<AgendamentoEmail> listarPorNaoAgendado() {
		return dao.listarPorNaoAgendado();
	}

	public void alterar(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(true);
		dao.alterar(agendamentoEmail);
	}

	public void enviar(AgendamentoEmail agendamentoEmail) {
		try {
			Thread.sleep(5000);
			LOGGER.info("O e-mail do(a) usuário(a) " + agendamentoEmail.getEmail() + " foi enviado!");
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
		}
	}
}
