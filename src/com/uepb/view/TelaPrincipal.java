package com.uepb.view;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.uepb.algoritmo.Cubo3D;
import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.Ponto3D;
import com.uepb.algoritmo.transformacoes2D.Operacoes;
import com.uepb.view.basica.Ajuda;
import com.uepb.view.basica.Retangulo;
import com.uepb.view.basica.Retas;
import com.uepb.view.basica.Valores;
import com.uepb.view.basica.Valores3D;
import com.uepb.view.circunferencia.PanelCircunfExplicita;
import com.uepb.view.circunferencia.PanelCircunfTrigonometrica;
import com.uepb.view.circunferencia.PanelCircunferencia;
import com.uepb.view.cisalhamento.ValoresCisalhamento;
import com.uepb.view.cisalhamento.ValoresCisalhamento3D;
import com.uepb.view.rotacao.ValoresRotacao;
import com.uepb.view.rotacao.ValoresRotacao3D;


@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	public static JMenuItem mntmTranslacao2D, mntmEscala2D, mntmRotacao2D,
			mntmCisalhamento2D, mntmReflexaoEmX2D, mntmReflexoEmY,
			mntmReflexaoEmXeY2D, mntmRotacaoEmX3D, mntmReflexaoEmY2D,
			mntmReflexaoEmY3D, mntmRotacaoEmX2D;
	public PanelReta panelReta;
	public PanelCircunferencia panelCircunferencia;
	public PanelCircunfTrigonometrica panelCircunfTringo;
	public PanelCircunfExplicita panelCircunfExplicita;
	public static PanelPlanoCartesiano planoCartesiano = new PanelPlanoCartesiano();
	public static PanelNormalizacao panelNormalizacao = new PanelNormalizacao();

	private static List<Ponto> listaGLOBAL = new ArrayList<Ponto>();
	private static List<Ponto3D> listaGLOBAL3D = new ArrayList<Ponto3D>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Interface principal.
	 */
	public TelaPrincipal() {
		setTitle("Computa\u00E7\u00E3o gr\u00E1fica - 2015");
		// Comandos do teclado.
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_R)
						&& ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					panelReta = new PanelReta();
					getContentPane().removeAll();
					getContentPane().add(panelReta);
					validate();
					repaint();
				}
				if ((e.getKeyCode() == KeyEvent.VK_M)
						&& ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					panelCircunferencia = new PanelCircunferencia();
					getContentPane().removeAll();
					getContentPane().add(panelCircunferencia);
					validate();
					repaint();
				}
				if ((e.getKeyCode() == KeyEvent.VK_T)
						&& ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					panelCircunfTringo = new PanelCircunfTrigonometrica();
					getContentPane().removeAll();
					getContentPane().add(panelCircunfTringo);
					validate();
					repaint();
				}
				if (e.getKeyCode() == KeyEvent.VK_E && KeyEvent.CTRL_MASK != 0) {
					panelCircunfExplicita = new PanelCircunfExplicita();
					getContentPane().removeAll();
					getContentPane().add(panelCircunfExplicita);
					validate();
					repaint();
				}
				if (e.getKeyCode() == KeyEvent.VK_H && KeyEvent.CTRL_MASK != 0) {
					new Ajuda().setVisible(true);
				}

				if (e.getKeyCode() == KeyEvent.VK_R && KeyEvent.CTRL_MASK != 0) {
					try {
						listaGLOBAL.clear();
						new Retangulo();
						validate();
						repaint();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_C && KeyEvent.CTRL_MASK != 0) {
					listaGLOBAL.clear();
					new Cubo();
					validate();
					repaint();
				}

				// Cisalhamento
				if (e.getKeyCode() == KeyEvent.VK_X && KeyEvent.SHIFT_MASK != 0) {
					new ValoresCisalhamento(listaGLOBAL, "cisa x");
				}
				if (e.getKeyCode() == KeyEvent.VK_Y && KeyEvent.SHIFT_MASK != 0) {
					new ValoresCisalhamento(listaGLOBAL, "cisa y");
				}
				if (e.getKeyCode() == KeyEvent.VK_Z && KeyEvent.SHIFT_MASK != 0) {
					new ValoresCisalhamento(listaGLOBAL, "cisa z");
				}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 720);
		setLocationRelativeTo(null);

		JMenuBar barraDeMenu = new JMenuBar();
		barraDeMenu.setMaximumSize(new Dimension(2312, 1));
		setJMenuBar(barraDeMenu);

		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.setMaximumSize(new Dimension(100, 120));
		mntmHome.setIgnoreRepaint(true);
		mntmHome.setInheritsPopupMenu(true);
		mntmHome.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/com/uepb/icon/home.png")));
		mntmHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(null);
				setContentPane(contentPane);
				getContentPane().add(panelNormalizacao);
				validate();
				repaint();

			}
		});
		barraDeMenu.add(mntmHome);

		JMenu menuCoordenadas = new JMenu("Coordenadas");
		menuCoordenadas.setMaximumSize(new Dimension(90, 120));
		barraDeMenu.add(menuCoordenadas);

		JMenu mnCircunferencia = new JMenu("Circunferencia");
		mnCircunferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCircunferencia = new PanelCircunferencia();
				getContentPane().removeAll();
				getContentPane().add(panelCircunferencia);
				validate();
				repaint();
			}
		});

		JMenu mnRetas = new JMenu("Retas");
		menuCoordenadas.add(mnRetas);

		JMenuItem mntmDda = new JMenuItem("DDA");
		mntmDda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Retas("dda");
			}
		});
		mnRetas.add(mntmDda);

		JMenuItem mntmPontoMdio = new JMenuItem("Ponto m\u00E9dio");
		mntmPontoMdio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Retas("pm");
			}
		});
		mnRetas.add(mntmPontoMdio);
		menuCoordenadas.add(mnCircunferencia);

		JMenuItem mntmPontoMedio = new JMenuItem("Ponto medio");
		mntmPontoMedio.setToolTipText("Ctrl + m");
		mntmPontoMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCircunferencia = new PanelCircunferencia();
				getContentPane().removeAll();
				getContentPane().add(panelCircunferencia);
				validate();
				repaint();
			}
		});
		mnCircunferencia.add(mntmPontoMedio);

		JMenuItem mntmEquaoExplicita = new JMenuItem(
				"Equa\u00E7\u00E3o explicita");
		mntmEquaoExplicita.setToolTipText("Ctrl + e");
		mntmEquaoExplicita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCircunfExplicita = new PanelCircunfExplicita();
				getContentPane().removeAll();
				getContentPane().add(panelCircunfExplicita);
				validate();
				repaint();
			}
		});
		mnCircunferencia.add(mntmEquaoExplicita);

		JMenuItem mntmTrigonometrica = new JMenuItem("Trigonometrica");
		mntmTrigonometrica.setToolTipText("Ctrl + t");
		mnCircunferencia.add(mntmTrigonometrica);
		mntmTrigonometrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCircunfTringo = new PanelCircunfTrigonometrica();
				getContentPane().removeAll();
				getContentPane().add(panelCircunfTringo);
				validate();
				repaint();
			}
		});

		JMenuItem mntmRetangulo = new JMenuItem("Retangulo");
		mntmRetangulo.setToolTipText("Ctrl + r");
		mntmRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listaGLOBAL.clear();
					new Retangulo();
					validate();
					repaint();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		menuCoordenadas.add(mntmRetangulo);

		JMenuItem mntmCubo = new JMenuItem("Cubo");
		mntmCubo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaGLOBAL.clear();
				new Cubo();
				validate();
				repaint();
			}
		});
		menuCoordenadas.add(mntmCubo);

		JMenu mnTransformaes = new JMenu("Transforma\u00E7\u00F5es");
		barraDeMenu.add(mnTransformaes);

		JMenu mnd2D = new JMenu("2D");
		mnd2D.setOpaque(true);
		mnd2D.setMinimumSize(new Dimension(200, 60));
		mnd2D.setMaximumSize(new Dimension(200, 32767));
		mnTransformaes.add(mnd2D);

		mntmCisalhamento2D = new JMenuItem("Cisalhamento");
		mntmCisalhamento2D.setToolTipText("SHIFT + c");
		mnd2D.add(mntmCisalhamento2D);
		mntmCisalhamento2D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ValoresCisalhamento(listaGLOBAL, "cisa x");
				} catch (Exception e2) {
					e2.getCause();
				}
			}
		});

		mntmEscala2D = new JMenuItem("Escala");
		mntmEscala2D.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Valores("escala");
				repaint();
			}
		});
		mnd2D.add(mntmEscala2D);

		mntmRotacao2D = new JMenuItem("Rota\u00E7\u00E3o");
		mntmRotacao2D.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getLista().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Imagem não criada.");
				} else {
					new ValoresRotacao();
					repaint();
					validate();
				}
			}
		});
		mnd2D.add(mntmRotacao2D);

		JMenu mnReflexao = new JMenu("Reflex\u00E3o");
		mnd2D.add(mnReflexao);

		mntmReflexaoEmX2D = new JMenuItem("Reflex\u00E3o em X");
		mntmReflexaoEmX2D.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				List<Ponto> lstP = new Operacoes().reflexaoX(getLista());

				PanelReta.panelPlanoCartesiano.limparImagem();
				setLista(lstP);
				povoarRetas(getLista());
				TelaPrincipal.panelNormalizacao.repaint();
			}
		});
		mnReflexao.add(mntmReflexaoEmX2D);

		mntmReflexaoEmY2D = new JMenuItem("Reflexao em Y");
		mntmReflexaoEmY2D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Ponto> lista = getLista();

				List<Ponto> lstP = new Operacoes().reflexaoY(lista);

				PanelReta.panelPlanoCartesiano.limparImagem();
				setLista(lstP);
				povoarRetas(getLista());
				TelaPrincipal.panelNormalizacao.repaint();
			}
		});
		mnReflexao.add(mntmReflexaoEmY2D);

		mntmReflexaoEmXeY2D = new JMenuItem("Reflex\u00E3o em X e Y");
		mntmReflexaoEmXeY2D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Ponto> lista = getLista();

				List<Ponto> lstP = new Operacoes().reflexaoXY(lista);

				PanelReta.panelPlanoCartesiano.limparImagem();
				setLista(lstP);
				povoarRetas(getLista());
				TelaPrincipal.panelNormalizacao.repaint();
			}
		});
		mnReflexao.add(mntmReflexaoEmXeY2D);

		mntmTranslacao2D = new JMenuItem("Transla\u00E7\u00E3o");
		mntmTranslacao2D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Valores("translacao");
				TelaPrincipal.panelNormalizacao.repaint();
				repaint();
			}
		});
		mnd2D.add(mntmTranslacao2D);

		JMenu mnd3D = new JMenu("3D");
		mnd3D.setMinimumSize(new Dimension(100, 0));
		mnTransformaes.add(mnd3D);

		JMenuItem mntmEscala3D = new JMenuItem("Escala");
		mntmEscala3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ValoresEscala3D();
			}
		});

		JMenu mnCisalhamento = new JMenu("Cisalhamento");
		mnd3D.add(mnCisalhamento);

		JMenuItem mntmCisalhamentoEmX3D = new JMenuItem("Cisalhamento em X");
		mntmCisalhamentoEmX3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresCisalhamento3D("X");
			}
		});
		mnCisalhamento.add(mntmCisalhamentoEmX3D);

		JMenuItem mntmCisalhamentoEmY3D = new JMenuItem("Cisalhamento em Y");
		mntmCisalhamentoEmY3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ValoresCisalhamento3D("Y");
			}
		});
		mnCisalhamento.add(mntmCisalhamentoEmY3D);

		JMenuItem mntmCisalhamentoEmZ3D = new JMenuItem("Cisalhamento em Z");
		mntmCisalhamentoEmZ3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresCisalhamento3D("Z");
			}
		});
		mnCisalhamento.add(mntmCisalhamentoEmZ3D);

		mnd3D.add(mntmEscala3D);

		JMenu mnRotao = new JMenu("Rota\u00E7\u00E3o");
		mnd3D.add(mnRotao);

		JMenuItem mntmRotacaoEmX3D = new JMenuItem(
				"Rota\u00E7\u00E3o em torno de X");
		mntmRotacaoEmX3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresRotacao3D("x");
			}
		});
		mnRotao.add(mntmRotacaoEmX3D);

		JMenuItem mntmRotaoEmY3D = new JMenuItem(
				"Rota\u00E7\u00E3o em torno de Y");
		mntmRotaoEmY3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresRotacao3D("y");
			}
		});
		mnRotao.add(mntmRotaoEmY3D);

		JMenuItem mntmRotaoEmZ3D = new JMenuItem(
				"Rota\u00E7\u00E3o em torno de Z");
		mntmRotaoEmZ3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresRotacao3D("z");
			}
		});
		mnRotao.add(mntmRotaoEmZ3D);

		JMenu mnReflexao3d = new JMenu("Reflex\u00E3o");
		mnd3D.add(mnReflexao3d);

		JMenuItem mntmReflexaoXY3D = new JMenuItem("Reflex\u00E3o em XY");
		mntmReflexaoXY3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				PanelPlanoCartesiano.add3D(true);

				List<Ponto3D> lst = new Cubo3D().reflexaoXY(listaGLOBAL3D);

				TelaPrincipal.setListaGLOBAL3D(lst);
				TelaPrincipal.povoar3D();
				TelaPrincipal.panelNormalizacao.repaint();
				repaint();
				validate();
			}
		});
		mnReflexao3d.add(mntmReflexaoXY3D);

		JMenuItem mntmReflexaoEmYZ3D = new JMenuItem("Reflex\u00E3o em YZ");
		mntmReflexaoEmYZ3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				PanelPlanoCartesiano.add3D(true);

				List<Ponto3D> lst = new Cubo3D().reflexaoYZ(listaGLOBAL3D);

				TelaPrincipal.setListaGLOBAL3D(lst);
				TelaPrincipal.povoar3D();
				TelaPrincipal.panelNormalizacao.repaint();
				repaint();
				validate();
			}
		});
		mntmReflexaoEmY3D = new JMenuItem("3D");
		mntmReflexaoEmY3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				PanelPlanoCartesiano.add3D(true);

				List<Ponto3D> lst = new Cubo3D().reflexaoYZ(listaGLOBAL3D);

				TelaPrincipal.setListaGLOBAL3D(lst);;
				TelaPrincipal.povoar3D();
				TelaPrincipal.panelNormalizacao.repaint();
				repaint();
				validate();
			}
		});
		mnReflexao3d.add(mntmReflexaoEmYZ3D);

		JMenuItem mntmReflexaoEmXZ3D = new JMenuItem("Reflex\u00E3o em XZ");
		mntmReflexaoEmXZ3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				PanelPlanoCartesiano.add3D(true);

				List<Ponto3D> lst = new Cubo3D().reflexaoXZ(listaGLOBAL3D);

				TelaPrincipal.setListaGLOBAL3D(lst);
				TelaPrincipal.povoar3D();
				TelaPrincipal.panelNormalizacao.repaint();
				repaint();
				validate();
			}
		});
		mnReflexao3d.add(mntmReflexaoEmXZ3D);

		JMenuItem mntmTranslao3D = new JMenuItem("Transla\u00E7\u00E3o");
		mntmTranslao3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Valores3D("translacao");
				TelaPrincipal.panelNormalizacao.repaint();
				revalidate();
				repaint();
			}
		});
		mnd3D.add(mntmTranslao3D);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setMaximumSize(new Dimension(140, 120));
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Ajuda().setVisible(true);
			}
		});
		barraDeMenu.add(mntmSobre);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setToolTipText("Sair");
		mntmSair.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/com/uepb/icon/icon-sair-logado.png")));
		mntmSair.setMaximumSize(new Dimension(120, 32767));
		barraDeMenu.add(mntmSair);
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		

		getContentPane().add(panelNormalizacao);
	}

	/**
	 * @param listaPontos
	 */
	public static void povoarRetas(List<Ponto> pontos) {
		try {
			for (Ponto ponto : pontos) {
				PanelReta.panelPlanoCartesiano.desenharPixel(
						ponto.getX() + 300, -ponto.getY() + 300, Color.BLUE);
			}
		} catch (Exception e) {
			System.out.println("Erro ao povoar os valores.");
		}
		TelaPrincipal.panelNormalizacao.repaint();
	}

	/**
	 * @param listaPontos
	 */
	public static void povoar3D() {
		try {
			for (Ponto3D ponto : getListaGLOBAL3D()) {
				if (ponto.getZ() == 0) {
					PanelReta.panelPlanoCartesiano
							.desenharPixel(ponto.getX() + 300,
									-ponto.getY() + 300, Color.BLUE);
				} else {
					PanelReta.panelPlanoCartesiano.desenharPixel(ponto.getX()
							+ 300 - ponto.getZ() / 2, -ponto.getY() + 300
							+ ponto.getZ() / 2, Color.BLUE);

				}

			}
		} catch (Exception e) {
			System.out.println("Erro ao povoar os valores nas 3 dimensões.");
		}
		TelaPrincipal.panelNormalizacao.repaint();
	}

	/**
	 * @return the lista em 2D (Duas dimenções)
	 */
	public static List<Ponto> getLista() {
		return listaGLOBAL;
	}

	/**
	 * @param lista
	 *            the lista to set
	 */
	public static void setLista(List<Ponto> lista) {
		TelaPrincipal.listaGLOBAL = lista;
	}

	/**
	 * Lista de coordenadas em 3D (Três dimenções)
	 * @return the listaGLOBAL3D 
	 */
	public static List<Ponto3D> getListaGLOBAL3D() {
		return listaGLOBAL3D;
	}

	/**
	 * @param listaGLOBAL3D the listaGLOBAL3D to set
	 */
	public static void setListaGLOBAL3D(List<Ponto3D> listaGLOBAL3D) {
		TelaPrincipal.listaGLOBAL3D = listaGLOBAL3D;
	}
}
