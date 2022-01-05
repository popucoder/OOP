package DOANCUOIKI.management;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import DOANCUOIKI.util.RWFile;

public class Management<T> implements IManagement<T>{
  protected List<T> list;
  protected int listSize = 0;

  public int getListSize() {
    return listSize;
  }

  @Override
  public List<T> GetList() {
    return list;
  }

  @Override
  public void LoadFile(String path) {
    File file = new File(path);
    try {
      if (file.exists()) {
        list = (ArrayList<T>) RWFile.readObject(path);
        listSize = list.size();
      } else {
        file.createNewFile();
      }
    } catch (Exception e) {
    }
  }

  @Override
  public boolean Add(T obj, String path) {
    list.add(obj);
    listSize++;

    try {
      RWFile.writeObject(path, list);
    } catch (Exception e) {
    }

    return true;
  }

  @Override
  public boolean Delete(int id,String path) {

    if(id >= listSize) return false;
    list.remove(id);
    listSize--;

    try {
      RWFile.writeObject(path, list);
    } catch (Exception e) {
    }

    return true;

  }

  @Override
  public boolean Update(int id, T obj, String path) {
    if(id >= listSize) return false;
    list.set(id, obj);

    try {
      RWFile.writeObject(path, list);
    } catch (Exception e) {
      
    }
    return true;
  }
}
