package task6;

import common.Helper;
import common.CustomException;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Process {
    public <T> List<T> createList() {
        return new ArrayList<T>();
    }

    public <T> int length(List<T> list) throws CustomException {
        Helper.validate(list);
        return list.size();
    }

    public <T> boolean add(List<T> list, T value) throws CustomException {
        Helper.validate(list);
        return list.add(value);
    }

    public <T> int indexOf(List<T> list, T value) throws CustomException {
        Helper.validate(list);
        Helper.validate(value);
        return list.indexOf(value);
    }

    public <T> T get(List<T> list, int index) throws CustomException {
        Helper.validate(index);
        Helper.validateTheLength(length(list) - 1, index);
        return list.get(index);
    }

    public <T> int lastIndexOf(List<T> list, T value) throws CustomException {
        Helper.validate(list);
        Helper.validate(value);
        return list.lastIndexOf(value);
    }

    public <T> void add(int index, T value, List<T> list) throws CustomException {
        Helper.validate(list);
        Helper.validate(value);
        Helper.validate(index);
        list.add(index, value);
    }

    public <T> List<T> subList(int start, int end, List<T> list) throws CustomException {
        Helper.validate(start);
        Helper.validate(end);
        Helper.validate(list);
        Helper.validateTheLength(length(list), end);
        return list.subList(start, end);
    }

    public <T> boolean addAll(List<T> temp, List<T> list) throws CustomException {
        Helper.validate(temp);
        Helper.validate(list);
        return list.addAll(temp);
    }

    public <T> boolean addAll(int index, List<T> temp, List<T> list) throws CustomException {
        Helper.validate(temp);
        Helper.validate(index);
        Helper.validate(list);
        return list.addAll(index, temp);
    }

    public <T> T remove(int index, List<T> list) throws CustomException {
        Helper.validate(index);
        Helper.validate(list);
        Helper.validateTheLength(length(list) - 1, index);
        return list.remove(index);
    }

    public <T> boolean removeAll(List<T> temp, List<T> list) throws CustomException {
        Helper.validate(temp);
        Helper.validate(list);
        return list.removeAll(temp);
    }

    public <T> boolean retainAll(List<T> temp, List<T> list) throws CustomException {
        Helper.validate(temp);
        Helper.validate(list);
        return list.retainAll(temp);
    }

    public <T> boolean contains(List<T> list, T value) throws CustomException {
        Helper.validate(value);
        Helper.validate(list);
        return list.contains(value);
    }

    public <T> Iterator<T> iterator(List<T> list) throws CustomException {
        Helper.validate(list);
        return list.iterator();
    }
}
