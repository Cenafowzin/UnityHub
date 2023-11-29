package br.gov.cesarschool.project.unityhub.negocio.geral;

public class StringUtil {
	private StringUtil() {}
	public static boolean ehNuloOuBranco(String str) {
		return str == null || str.trim().equals("");
	}
}
