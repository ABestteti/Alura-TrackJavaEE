package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5640846148829616329L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String filtro = req.getParameter("filtro");
		
		writer.println("<html><body>");
		writer.println("Resultado da busca: " + filtro + "</br>");
		
		writer.println("<ul>");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		if (!empresas.isEmpty()) {
			for (Empresa empresa : empresas) {
				writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
			}
		} else {
			writer.println("<li>Não foram encontrados resultados para o filtro informado.</li>");
		}
		writer.println("</ul>");		
		writer.print("</body></html>");
	}
}
