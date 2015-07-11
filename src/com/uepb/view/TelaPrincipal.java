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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.uepb.algoritmo.Cubo3D;
import com.uepb.algoritmo.Ponto;
import com.uepb.algoritmo.transformacoes2D.Operacoes;
import com.uepb.algoritmo.transformacoes2D.Operacoes3D;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	static JMenuItem mntmTranslacao, mntmEscala, mntmRotacao, mntmCisalhamento,
			mntmReflexaoEmX, mntmReflexoEmY, mntmReflexaoEmXeY,
			mntmReflexaoEmY, mntmReflexaoEmY3D;
	public PanelReta panelReta;
	public PanelCircunferencia panelCircunferencia;
	public PanelCircunfTrigonometrica panelCircunfTringo;
	public PanelCircunfExplicita panelCircunfExplicita;
	public static PanelPlanoCartesiano planoCartesiano = new PanelPlanoCartesiano();
	public static PanelNormalizacao panelNormalizacao = new PanelNormalizacao();

	private static List<Ponto> listaGLOBAL = new ArrayList<Ponto>();

	/**
	 * Launch the application.
	 */
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
				if ((e.getKeyCode() == KeyEvent.VK_C)
						&& ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					panelCircunferencia = new PanelCircunferencia();
					getContentPane().removeAll();
					getContentPane().add(panelCircunferencia);
					validate();
					repaint();
				}
				if ((e.getKeyCode() == KeyEvent.VK_H)
						&& ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					getContentPane().removeAll();
					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					contentPane.setLayout(null);
					setContentPane(contentPane);
					getContentPane().add(panelNormalizacao);
					validate();
					repaint();
				}
				if (e.getKeyCode() == KeyEvent.VK_A && KeyEvent.CTRL_MASK != 0) {
					new Ajuda().setVisible(true);
				}
				if (e.getKeyCode() == KeyEvent.VK_X && KeyEvent.CTRL_MASK != 0) {
					List<Ponto> lista = getLista();

					System.out.println("Reflexao em X");
					List<Ponto> lstP = new Operacoes().reflexaoX(lista);

					PanelReta.panelPlanoCartesiano.limparImagem();
					setLista(lstP);
					povoarRetas(lstP);
				}
				if (e.getKeyCode() == KeyEvent.VK_Y && KeyEvent.CTRL_MASK != 0) {
					List<Ponto> lista = getLista();
					List<Ponto> lstP = new Operacoes().reflexaoY(lista);
					PanelReta.panelPlanoCartesiano.limparImagem();
					setLista(lstP);
					povoarRetas(lstP);
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
		mntmHome.setMaximumSize(new Dimension(80, 120));
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

		JMenuItem itemMenuReta = new JMenuItem("Reta");
		itemMenuReta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelReta = new PanelReta();
				getContentPane().removeAll();
				getContentPane().add(panelReta);
				validate();
				repaint();
			}
		});

		JMenuItem menuItemNormalizacao = new JMenuItem("Normalização");
		menuCoordenadas.add(menuItemNormalizacao);
		menuItemNormalizacao.setEnabled(false);

		menuCoordenadas.add(itemMenuReta);

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
		menuCoordenadas.add(mnCircunferencia);

		JMenuItem mntmPontoMedio = new JMenuItem("Ponto medio");
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
		mntmRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaGLOBAL.clear();
				new Retangulo();
				validate();
				repaint();
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

		JMenu mnd = new JMenu("2D");
		mnd.setOpaque(true);
		mnd.setMinimumSize(new Dimension(200, 60));
		mnd.setMaximumSize(new Dimension(200, 32767));
		mnTransformaes.add(mnd);

		mntmCisalhamento = new JMenuItem("Cisalhamento");
		mnd.add(mntmCisalhamento);
		mntmCisalhamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresCisalhamento(listaGLOBAL, "cisa x");
			}
		});

		mntmEscala = new JMenuItem("Escala");
		mntmEscala.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Valores("escala");
				repaint();
			}
		});
		mnd.add(mntmEscala);

		mntmRotacao = new JMenuItem("Rota\u00E7\u00E3o");
		mntmRotacao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ValoresRotacao();
				repaint();
				validate();
			}
		});
		mnd.add(mntmRotacao);

		JMenu mnReflexao = new JMenu("Reflex\u00E3o");
		mnd.add(mnReflexao);

		mntmReflexaoEmX = new JMenuItem("Reflex\u00E3o em X");
		mntmReflexaoEmX.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				List<Ponto> lstP = new Operacoes().reflexaoX(getLista());

				PanelReta.panelPlanoCartesiano.limparImagem();
				setLista(lstP);
				povoarRetas(TelaPrincipal.listaGLOBAL);
				TelaPrincipal.panelNormalizacao.repaint();
			}
		});
		mnReflexao.add(mntmReflexaoEmX);

		mntmReflexaoEmY = new JMenuItem("Reflexao em Y");
		mntmReflexaoEmY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Ponto> lista = getLista();

				List<Ponto> lstP = new Operacoes().reflexaoY(lista);

				PanelReta.panelPlanoCartesiano.limparImagem();
				setLista(lstP);
				povoarRetas(lstP);
				TelaPrincipal.panelNormalizacao.repaint();
			}
		});
		mnReflexao.add(mntmReflexaoEmY);

		mntmReflexaoEmXeY = new JMenuItem("Reflex\u00E3o em X e Y");
		mntmReflexaoEmXeY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Ponto> lista = getLista();

				List<Ponto> lstP = new Operacoes().reflexaoXY(lista);

				PanelReta.panelPlanoCartesiano.limparImagem();
				setLista(lstP);
				povoarRetas(lstP);
				TelaPrincipal.panelNormalizacao.repaint();
			}
		});
		mnReflexao.add(mntmReflexaoEmXeY);

		mntmTranslacao = new JMenuItem("Transla\u00E7\u00E3o");
		mntmTranslacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Valores("translacao");
				TelaPrincipal.panelNormalizacao.repaint();
				repaint();
			}
		});
		mnd.add(mntmTranslacao);

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

		JMenuItem mntmCisalhamentoEmX = new JMenuItem("Cisalhamento em X");
		mntmCisalhamentoEmX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresCisalhamento3D("X");
			}
		});
		mnCisalhamento.add(mntmCisalhamentoEmX);

		JMenuItem mntmCisalhamentoEmY = new JMenuItem("Cisalhamento em Y");
		mntmCisalhamentoEmY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ValoresCisalhamento3D("Y");
			}
		});
		mnCisalhamento.add(mntmCisalhamentoEmY);

		JMenuItem mntmCisalhamentoEmZ = new JMenuItem("Cisalhamento em Z");
		mntmCisalhamentoEmZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresCisalhamento3D("Z");
			}
		});
		mnCisalhamento.add(mntmCisalhamentoEmZ);
		
		
		mnd3D.add(mntmEscala3D);

		JMenu mnRotao = new JMenu("Rota\u00E7\u00E3o");
		mnd3D.add(mnRotao);

		JMenuItem mntmRotacaoEmX = new JMenuItem(
				"Rota\u00E7\u00E3o em torno de X");
		mntmRotacaoEmX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresRotacao3D("x");
			}
		});
		mnRotao.add(mntmRotacaoEmX);

		JMenuItem mntmRotaoEmY = new JMenuItem(
				"Rota\u00E7\u00E3o em torno de Y");
		mntmRotaoEmY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresRotacao3D("y");
			}
		});
		mnRotao.add(mntmRotaoEmY);

		JMenuItem mntmRotaoEmZ = new JMenuItem(
				"Rota\u00E7\u00E3o em torno de Z");
		mntmRotaoEmZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValoresRotacao3D("z");
			}
		});
		mnRotao.add(mntmRotaoEmZ);

		JMenu mnReflexao3d = new JMenu("Reflex\u00E3o");
		mnd3D.add(mnReflexao3d);

		JMenuItem mntmReflexaoXY = new JMenuItem("Reflex\u00E3o em XY");
		mntmReflexaoXY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				PanelPlanoCartesiano.add3D(true);

				List<Ponto> lst = new Cubo3D().reflexaoXY(listaGLOBAL);

				TelaPrincipal.setLista(lst);
				TelaPrincipal.povoar3D();
				TelaPrincipal.panelNormalizacao.repaint();
				repaint();
				validate();
			}
		});
		mnReflexao3d.add(mntmReflexaoXY);

		JMenuItem mntmReflexaoEmYZ = new JMenuItem("Reflex\u00E3o em YZ");
		mntmReflexaoEmYZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				PanelPlanoCartesiano.add3D(true);

				List<Ponto> lst = new Cubo3D().reflexaoYZ(listaGLOBAL);

				TelaPrincipal.setLista(lst);
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

				List<Ponto> lst = new Cubo3D().reflexaoYZ(listaGLOBAL);

				TelaPrincipal.setLista(lst);
				TelaPrincipal.povoar3D();
				TelaPrincipal.panelNormalizacao.repaint();
				repaint();
				validate();
			}
		});
		mnReflexao3d.add(mntmReflexaoEmYZ);

		JMenuItem mntmReflexaoEmXZ = new JMenuItem("Reflex\u00E3o em XZ");
		mntmReflexaoEmXZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				PanelPlanoCartesiano.add3D(true);

				List<Ponto> lst = new Cubo3D().reflexaoXZ(listaGLOBAL);

				TelaPrincipal.setLista(lst);
				TelaPrincipal.povoar3D();
				TelaPrincipal.panelNormalizacao.repaint();
				repaint();
				validate();
			}
		});
		mnReflexao3d.add(mntmReflexaoEmXZ);

		JMenuItem mntmTranslao = new JMenuItem("Transla\u00E7\u00E3o");
		mntmTranslao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Valores3D("translacao");
				TelaPrincipal.panelNormalizacao.repaint();
				revalidate();
				repaint();
			}
		});
		mnd3D.add(mntmTranslao);

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
	public static void povoarRetas(List<Ponto> listaPontos) {
		try {
			for (Ponto ponto : listaPontos) {
				PanelReta.panelPlanoCartesiano.desenharPixel(
						ponto.getX() + 300, -ponto.getY() + 300, Color.GREEN);
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
			for (Ponto ponto : getLista()) {
				if (ponto.getZ() == 0) {
					PanelReta.panelPlanoCartesiano.desenharPixel(
							ponto.getX() + 300, -ponto.getY() + 300, Color.RED);
				} else {
					PanelReta.panelPlanoCartesiano.desenharPixel(ponto.getX()
							+ 300 - ponto.getZ() / 2, -ponto.getY() + 300
							+ ponto.getZ() / 2, Color.RED);

				}

			}
		} catch (Exception e) {
			System.out.println("Erro ao povoar os valores nas 3 dimensões.");
		}
		TelaPrincipal.panelNormalizacao.repaint();
	}

	/**
	 * @return the lista
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
}
