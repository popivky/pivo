import java.util.ArrayList;

public class TodoList {

    ArrayList<String> deals = new ArrayList<>();
    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        deals.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления

        if (index < deals.size()  && index > -1) {

            deals.add(index, todo);

        } else deals.add(todo);
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения

        if (index < deals.size() && index > -1){
            deals.set(index, todo);
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index < deals.size() && index > -1) {
            deals.remove(index);
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return deals;
    }

}