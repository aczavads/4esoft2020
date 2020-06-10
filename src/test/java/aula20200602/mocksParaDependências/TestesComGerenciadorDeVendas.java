package aula20200602.mocksParaDependências;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestesComGerenciadorDeVendas {
	@Mock
	GerenciadorDeParâmetros gdp;

	@Test
	void teste_usando_mock_do_mockito() {
		UnidadeFederativa pr = new UnidadeFederativa("Paraná");
		UnidadeFederativa sc = new UnidadeFederativa("Santa Catarina");
		UnidadeFederativa sp = new UnidadeFederativa("São Paulo");
		
		//GerenciadorDeParâmetros gdp = Mockito.mock(GerenciadorDeParâmetros.class);
		System.out.println(gdp.getClass().getName());
		when(gdp.obterAlíquotaICMS(pr)).thenReturn(new BigDecimal("17.00"));
		when(gdp.obterAlíquotaICMS(sc)).thenReturn(new BigDecimal("7.00"));
		when(gdp.obterAlíquotaICMS(sp)).thenReturn(new BigDecimal("12.00"));
		GerenciadorDeVendas gv = new GerenciadorDeVendas(gdp);
		
		Venda vendaPR = gv.efetuarVenda(new BigDecimal("1000.00"), pr);
		Venda vendaSC = gv.efetuarVenda(new BigDecimal("2000.00"), sc);
		Venda vendaSP = gv.efetuarVenda(new BigDecimal("3000.00"), sp);
		
		assertEquals(new BigDecimal("17.00"), vendaPR.getAlíquotaIcms());		
		assertEquals(new BigDecimal("1000.00"), vendaPR.getValor());		
		assertEquals(pr, vendaPR.getUfDestino());
		
		assertEquals(new BigDecimal("7.00"), vendaSC.getAlíquotaIcms());		
		assertEquals(new BigDecimal("2000.00"), vendaSC.getValor());		
		assertEquals(sc, vendaSC.getUfDestino());		

		assertEquals(new BigDecimal("12.00"), vendaSP.getAlíquotaIcms());		
		assertEquals(new BigDecimal("3000.00"), vendaSP.getValor());		
		assertEquals(sp, vendaSP.getUfDestino());		
	}
	
	@Test
	void teste_usando_proxy_dinâmico() {
		UnidadeFederativa pr = new UnidadeFederativa("Paraná");
		UnidadeFederativa sc = new UnidadeFederativa("Santa Catarina");
		UnidadeFederativa sp = new UnidadeFederativa("São Paulo");
		
		GerenciadorDeParâmetros gdp = criarProxy(GerenciadorDeParâmetros.class);
		GerenciadorDeVendas gv = new GerenciadorDeVendas(gdp);
		
		Venda vendaPR = gv.efetuarVenda(new BigDecimal("1000.00"), pr);
		Venda vendaSC = gv.efetuarVenda(new BigDecimal("2000.00"), sc);
		Venda vendaSP = gv.efetuarVenda(new BigDecimal("3000.00"), sp);
		
		assertEquals(new BigDecimal("17.00"), vendaPR.getAlíquotaIcms());		
		assertEquals(new BigDecimal("1000.00"), vendaPR.getValor());		
		assertEquals(pr, vendaPR.getUfDestino());
		
		assertEquals(new BigDecimal("7.00"), vendaSC.getAlíquotaIcms());		
		assertEquals(new BigDecimal("2000.00"), vendaSC.getValor());		
		assertEquals(sc, vendaSC.getUfDestino());		

		assertEquals(new BigDecimal("12.00"), vendaSP.getAlíquotaIcms());		
		assertEquals(new BigDecimal("3000.00"), vendaSP.getValor());		
		assertEquals(sp, vendaSP.getUfDestino());		

	}

	private GerenciadorDeParâmetros criarProxy(Class<?> classToMock) {
		GerenciadorDeParâmetros  gdp = (GerenciadorDeParâmetros) Proxy
				.newProxyInstance(
						TestesComGerenciadorDeVendas.class.getClassLoader(), 
						new Class[] {classToMock}, new InvocationHandler() {						
							@Override
							public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
								System.out.println("Invocando o método: " + method.getName());
								System.out.println("Com os parâmetros: ");
								for (Object param : args) {
									System.out.println("  " +param);
								}
								if (method.getName().equals("obterAlíquotaICMS")) {
									UnidadeFederativa uf = (UnidadeFederativa) args[0];
									if (uf.getNome().equals("Paraná")) 
										return new BigDecimal("17.00");
									if (uf.getNome().equals("Santa Catarina")) 
										return new BigDecimal("7.00");
									if (uf.getNome().equals("São Paulo")) 
										return new BigDecimal("12.00");									
								}
								return null;
							}
						});		
		return gdp;
	}
	

}
