/*
 * Класс Point3d представляет точку в трехмерном пространстве
 */
public class Point3D extends Point{
  private int z;

  public double getZ(){
    return z;
  }

  public void setZ(){
    this.z=z;
  }

  //Конструктор точки с 3 координатами
  public Point3D(int x, int y, int z){
    super(x,y);
    this.z=z;
  }

  @Override
  public String toString(){
    return "{" + x + ";" + y + ";" + z + "}";
  }

}
