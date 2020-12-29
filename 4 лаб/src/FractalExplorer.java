import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;


public class FractalExplorer
{
    private int displaySize;
    

    private JImageDisplay display;
    

    private FractalGenerator fractal;
    

    private Rectangle2D.Double range;
    
    /**
     * Конструктор, который принимает размер дисплея, сохраняет его и
     * инициализирует объекты диапазона и фрактал-генератора.
     */
    public FractalExplorer(int size) {
        /** Размер дисплея **/
        displaySize = size;
        
        /** Инициализирует фрактальный генератор и объекты диапазона. **/
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);
    
    }
    /**
     * Этот метод инициализирует графический интерфейс Swing, содержащего
     * JImageDisplay объект и кнопка для сброса дисплея.
     */
    public void createAndShowGUI()
    {
        display.setLayout(new BorderLayout());
        JFrame myframe = new JFrame("Fractal Explorer");
        myframe.add(display, BorderLayout.CENTER);
        JButton resetButton = new JButton("Сбросить дисплей");
        ResetHandler handler = new ResetHandler();
        resetButton.addActionListener(handler);
        myframe.add(resetButton, BorderLayout.SOUTH);

        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);
        
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /**
         * Разместите содержимое фрейма так, чтобы оно было видно, и
         * запретить изменение размера окна.
         */
        myframe.pack();
        myframe.setVisible(true);
        myframe.setResizable(false);
    }
    
    /**
     * метод для отображения фрактала. Этот метод зацикливается
     * через каждый пиксель на дисплее и вычисляет количество
     * итераций для соответствующих координат во фрактале
     */
    private void drawFractal()
    {
        /** Просматривайте каждый пиксель на дисплее */
        for (int x=0; x<displaySize; x++){
            for (int y=0; y<displaySize; y++){
                
                /**
                 * Найдите соответствующие координаты xCoord и yCoord
                 * в области отображения фрактала.
                 */
                double xCoord = fractal.getCoord(range.x,
                range.x + range.width, displaySize, x);
                double yCoord = fractal.getCoord(range.y,
                range.y + range.height, displaySize, y);
                
                /**
                 * Вычислить количество итераций для координат в
                 * область отображения фрактала.
                 */
                int iteration = fractal.numIterations(xCoord, yCoord);
                
                /** Если количество итераций равно -1, установите черный пиксель. */
                if (iteration == -1){
                    display.drawPixel(x, y, 0);
                }
                
                else {
                    /**
                     * В противном случае выберите значение оттенка на основе числа
                     * итераций.
                     */
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                
                    /** Обновите дисплей цветом для каждого пикселя. */
                    display.drawPixel(x, y, rgbColor);
                }
                
            }
        }
        /**
         * Когда все пиксели будут нарисованы, перекрасить JImageDisplay в соответствии с
         * текущее содержимое его изображения.
         */
        display.repaint();
    }
    /**
     * Внутренний класс для обработки событий ActionListener от кнопки сброса.
     */
    private class ResetHandler implements ActionListener
    {
        /**
         * Обработчик сбрасывает диапазон до начального диапазона, заданного
         * генератором, а затем рисует фрактал.
         */
        public void actionPerformed(ActionEvent e)
        {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }
    /**
     * Внутренний класс для обработки событий MouseListener с дисплея.
     */
    private class MouseHandler extends MouseAdapter
    {
        /**
         * Когда обработчик получает событие щелчка мыши, он отображает пиксель-
         * координаты щелчка в области фрактала, который
         * отображается, а затем вызывает функцию RecenterAndZoomRange () генератора
         * метод с координатами, по которым был выполнен щелчок
         */
        @Override
        public void mouseClicked(MouseEvent e)
        {
            /** Получить координату x области отображения щелчка мыши. */
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x,
            range.x + range.width, displaySize, x);
            int y = e.getY();
            double yCoord = fractal.getCoord(range.y,
            range.y + range.height, displaySize, y);

            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            
            /**
             * Перерисовываем фрактал после области
             * отображение изменилось.
             */
            drawFractal();
        }
    }
    
    /**
     * Статический метод main () для запуска FractalExplorer. Инициализирует новый
     * Экземпляр FractalExplorer с размером дисплея 800, вызывает
     * createAndShowGUI () в объекте проводника, а затем вызывает
     * drawFractal () в проводнике, чтобы увидеть исходный вид.
     */
    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(600);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}