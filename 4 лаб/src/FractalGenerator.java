import java.awt.geom.Rectangle2D;



public abstract class FractalGenerator {

    /**
     * @param rangeMin минимальное значение диапазона с плавающей запятой
     * @param rangeMax максимальное значение диапазона с плавающей запятой
     *
     * @param size размер измерения, от которого происходит координата пикселя.
     * Например, это может быть ширина изображения или высота изображения.
     */
    public static double getCoord(double rangeMin, double rangeMax,
        int size, int coord) {

        assert size > 0;
        assert coord >= 0 && coord < size;

        double range = rangeMax - rangeMin;
        return rangeMin + (range * (double) coord / (double) size);
    }


    /**
     * Устанавливает указанный прямоугольник, чтобы он содержал начальный диапазон, подходящий для
     * генерируемый фрактал.
     */
    public abstract void getInitialRange(Rectangle2D.Double range);


    /**
     * Обновляет текущий диапазон, чтобы он был центрирован по указанным координатам
     */
    public void recenterAndZoomRange(Rectangle2D.Double range,
        double centerX, double centerY, double scale) {

        double newWidth = range.width * scale;
        double newHeight = range.height * scale;

        range.x = centerX - newWidth / 2;
        range.y = centerY - newHeight / 2;
        range.width = newWidth;
        range.height = newHeight;
    }


    public abstract int numIterations(double x, double y);
   /**
     * Метод numIterations(double, double) реализует итеративную
     * функцию для фрактала Мандельброта. Константу с максимальным количеством
     * итераций можно определить следующим образом:
     * public static final int MAX_ITERATIONS = 2000;
     * Затем вы сможете ссылаться на эту переменную в вашей реализации.
    **/
    
}

