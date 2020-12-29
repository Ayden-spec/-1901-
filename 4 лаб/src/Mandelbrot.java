import java.awt.geom.Rectangle2D;


public class Mandelbrot extends FractalGenerator
{
    /**
     * Константа для количества максимальных итераций.
     */
    public static final int MAX_ITERATIONS = 2000;
    
    /**
     * Этот метод позволяет генератору фракталов указать, какая часть
     * комплексной плоскости наиболее интересна для фрактала.
     * Ему передается объект прямоугольника, и метод изменяет
     * Поля прямоугольника для отображения правильного начального диапазона фрактала.
     * Эта реализация устанавливает начальный диапазон в (-2 - 1.5i) - (1 + 1.5i)
     * или x = -2, y = -1,5, width = height = 3.
     */
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }
    
    /**
     * Этот метод реализует итерационную функцию для фрактала Мандельброта.
     */
    public int numIterations(double x, double y)
    {
        /** Старт с итераций в 0. */
        int iteration = 0;
        double zreal = 0;
        double zimaginary = 0;
        
        /**
         * Вычислить Zn = Zn-1 ^ 2 + c, где значения представляют собой комплексные числа, представленные
         * по zreal и zimaginary, Z0 = 0, а c - особая точка в
         * фрактал, который мы показываем (заданный x и y). Это повторяется
         * до Z ^ 2> 4 (абсолютное значение Z больше 2) или максимум
         * количество итераций достигнуто.
         */
        while (iteration < MAX_ITERATIONS &&
               zreal * zreal + zimaginary * zimaginary < 4)
        {
            double zrealUpdated = zreal * zreal - zimaginary * zimaginary + x;
            double zimaginaryUpdated = 2 * zreal * zimaginary + y;
            zreal = zrealUpdated;
            zimaginary = zimaginaryUpdated;
            iteration += 1;
        }
        
        /**
         * Если количество итераций достигнуто, вернуть -1, чтобы
         * указывают, что точка не вышла за пределы границы.
         */
        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }
        
        return iteration;
    }

}