package jogoDados; //trata-se do lugar a qual a classe está sendo implantada

import java.util.*; 
//Importação do java.util. Trata-se da biblioteca que permitirá chamar a função random

public class jogoDados { //declaração da classe pública que está sendo manipulada
	private Random randomNum = new Random(); //criação de um gerador seguro de números aleatórios
	private enum Status {Contiue, WON, LOST}; //declaração do tipo enum com um conjunto de constantes que determinarão o Status final do jogo. Constante privada (só pode ser modificada dentro desta classe).
	//Linha 10 a linha 14: declaração de variáveis privadas e de valores fixos do tipo inteiro que possuem , respectivamente, os valores: 2, 3, 7, 11 e 12. 
	private final static int SNAKE_EYES = 2;
	private final static int TREY = 3;
	private final static int SEVEN = 7;
	private final static int YO_LEVEN = 11;
	private final static int BOX_CARS = 12;
	
	public void play() { //tipo de retorno vazio ao método, seguido da ação de jogar
		int myPoint = 0; //declaração da variável do tipo inteiro cuja respresenta a pontuação inicial do jogador (0, no caso)
		Status gameStatus; //o Status permanece sem um resultado, pois ainda não houve nenhuma rodada para determiná-lo
		int sumDice = rollDice(); // sum = soma e Dice = dado, sendo assim, esta linha trata-se de uma variável do tipo inteiro que diz que a soma dos dados é equivalente ao resultado da primeira rodada
		
		switch (sumDice) { //estrutura condicional relativa ao resultado da soma
		/*linha 30 a linha 32: caso o resultado da primeira rodada seja igual a variável SEVEN, que possui valor 7, ou igual a variável YO_LEVEN, 
		 * que possui o valor 11, o status do jogador será igual a Status.WON, indicando que o jogador ganhou o jogo*/
		case SEVEN: 
		case YO_LEVEN:
			gameStatus=Status.WON;
		/*linha 35 a linha 37: mas caso o resultado seja igual a variável SNAKE_EYES, quepossui valor 2, ou igual a variável TREY, de valor 3, o status do jogador será igual a
		 * Status.LOST, indicando que o jogador perdeu o jogo*/
		case SNAKE_EYES:
			gameStatus=Status.LOST;
		case TREY:
			default:// comando para cqual o programa se recorrerá caso nenhum dos casos acima sejam atendidos
				gameStatus = Status.Contiue; //caso não ganhe ou perca, o status do jogador será equivalente a Status.Contiue, indicando que o jogador deve continuar jogando
				myPoint = sumDice; // irá relembrar a pontuação, indicando que a a variável myPoint será relativa a sumDice
				/*linha 44: é declarado o método System.out.printf que é uma string de formatação, ou seja, é um texto fixo que será exibido aos usuários seguido de um
				 *especificador de formato. Neste caso, foi determinado que o texto fixo é a mensagem "Point is" e a formatação %d trata-se de um número inteiro decimal, que 
				 *é equivalente a variável myPoint. Após a exibição da mensagem, há a quebra de linha (\n).*/
				System.out.printf("Point is %d\n", myPoint);
				break; //o comando break será acionado e interromperá o programa após uma das condições anteriores ser atendida
		} //fim do bloco da declaração switch 
		/*linha 49 e 50:declaração da estrutura de repetição "enquanto" que executará as instruções do bloco referente a uma expressão booleana, que, neste caso seria, enquanto 
		 *a variável gameStatus for igual a Status.Continue, o jogador deverá continuar jogando e iniciará uma nova rodada, onde os numeros de sumDice e da rodada da vez serão exibidos*/
	while (gameStatus==Status.Contiue) {
		sumDice = rollDice();
		/*linha 53 e 54: declaração da estrutura condicional if. Caso não seja o caso do jogador precisar continuar jogando, esta estrutura será acionada, onde se a variável 
		 *sumDice for equivalente a variável myPoint (que teve seu valor declarado no bloco anterior), o status do jogador será Status.WON (jogo ganho)*/
		if (sumDice == myPoint)
			gameStatus = Status.WON;
		/*linha 58 a 60: declaração da estrutura condicional else. Mas ainda sim, caso nenhuma das condições anteriores sejam atendidas, elas serão ignoradas e a condição 
		 *else if será efetuada, onde será informado em sua expressão que se a variável sumDice for igual a variável SEVEN, sua execução será determinar o status do jogador 
		 *como Status.LOST (jogo perdido)*/
		else
			if (sumDice == SEVEN)
				gameStatus = Status.LOST;
		} //fim do bloco da estrutura de condição + estrutura condicional 
	/*linha 65 a 68: instauração da estrutura condicional if/else, onde no if é declarado que se a variável gameStatus do jogador tiver anteriormente sido atribuída ao estado 
	 *de Status.WON (jogo ganho), uma string de texto será gerada, juntamente com a criação de uma nova linha, com a exibição da mensagem "Player wins!", mas caso essa condição
	 *não seja verdadeira o else irá exibir do mesmo modo a mensagem "Player Loses!"*/
	if (gameStatus==Status.WON)
		System.out.println("Player wins!");
	else
		System.out.println("Player Loses!");
	} //fim do método play()
	public int rollDice() { //instanciando o retorno as somas dadas pelos dados jogados
		/*linha 74 e 75: declaração de dois valores inteiros determinado através do método randomNum.nextInt() que é usado para obter retorno a um número aleatório. Sendo 
		 *assim as variáveis die1 e die2 serão, de modo separado, iguais a números aleatórios, no qual o valor a ser sorteado será de no minimo 1 e no máximo 6, já que são 
		 *correspondentes as possibilidades de faces num dado*/
		int die1 = 1 + randomNum.nextInt(6); 
		int die2 = 1 + randomNum.nextInt(6);
		int sum = die1 + die2; //soma os números aleatórios atribuídos as variáveis die1 e die2 e atribui o valor resultante na variável de valor inteiro sum
		/*linha 44: é declarada uma string de formatação, que será exibida ao usuário. Neste caso, o texto fixo é a mensagem "Player rolled" seguida da formatação %d = %d que
		 *trata-se dos dois números inteiros decimais resultantes da variável die1 e die2.. Após a exibição da mensagem, há a quebra de linha (\n).*/
     System.out.printf("Player rolled %d = %d\n", die1, die2, sum);
		return sum; //retorna ao valor da variável sum
	} //fim do método rollDice
	} //fim da classe jogoDados
