package br.gov.cesarschool.project.unityhub.negocio.geral;

public class ValidadorCPF {
	private ValidadorCPF() {}
	public static boolean ehCpfValido(String cpf) {
	    // Remove todos os caracteres que não são dígitos
	    cpf = cpf.replaceAll("[^\\d]", "");

	    if (StringUtil.ehNuloOuBranco(cpf) || cpf.length() != 11 || !cpf.chars().allMatch(Character::isDigit)) {
	        return false;
	    }

	    int sum = 0;
	    for (int i = 0; i < 9; i++) {
	        sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
	    }
	    int resto = sum % 11;
	    int primeiroDigito = resto < 2 ? 0 : 11 - resto;

	    sum = 0;
	    for (int i = 0; i < 10; i++) {
	        sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
	    }
	    resto = sum % 11;

	    int segundoDigito = resto < 2 ? 0 : 11 - resto;

	    return cpf.charAt(9) == Character.forDigit(primeiroDigito, 10) && cpf.charAt(10) == Character.forDigit(segundoDigito, 10);
	}
}
