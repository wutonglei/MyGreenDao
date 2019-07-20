package com.wutong.mygreendao;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wutong.mygreendao.green.dao.db.DaoSession;
import com.wutong.mygreendao.green.dao.db.People;
import com.wutong.mygreendao.green.dao.db.Student;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "trh" + this.getClass().getSimpleName();
    @BindView(R.id.tv_statue)
    TextView tvStatue;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_id)
    EditText etId;
    @BindView(R.id.tv_db_content)
    TextView tvDbContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_add, R.id.btn_delete, R.id.btn_update, R.id.btn_query, R.id.btn_up_db, R.id.btn_delete_all})
    public void onViewClicked(View view) {
        String name = etName.getText().toString().trim();
        String id = etId.getText().toString().trim();
        Log.i(TAG, "onViewClicked: id:" + id + "name:" + name);
        DaoSession daoSession = ((MyApplication) getApplication()).getDaoSession();

        switch (view.getId()) {
            case R.id.btn_add:
                if (id.length() > 0 && name.length() > 0) {
                    add(id, name);
                }
                break;
            case R.id.btn_delete:
                daoSession = ((MyApplication) getApplication()).getDaoSession();
                if (id.length() > 0) {
                    List<Student> students = query(id);
                    for (Student s : students) {
                        daoSession.delete(s);
                    }
                }
//                daoSession.delete(s);
                break;
            case R.id.btn_update:
                daoSession = ((MyApplication) getApplication()).getDaoSession();
                if (id.length() > 0) {
                    List<Student> students = query(id);
                    for (Student s : students) {
                        s.setName(name);
                        s.setAge(10086);
                        daoSession.update(s);
                    }
                }
                break;
            case R.id.btn_query:
                if (id.length() > 0) {
                    query(id);
                }

                break;
            case R.id.btn_up_db:
                break;
            case R.id.btn_delete_all:
                daoSession = ((MyApplication) getApplication()).getDaoSession();
                daoSession.deleteAll(Student.class);

                break;
        }
        showDbContent();
    }

    private List<Student> query(String id) {
        DaoSession daoSession;
        daoSession = ((MyApplication) getApplication()).getDaoSession();
        List<Student> students = daoSession.queryRaw(Student.class, " where STUDENT_NO = ?", id);
        List<People> peoples = daoSession.queryRaw(People.class, " where STUDENT_NO = ?", id);
        tvResult.setText("查询结果：");
        for (Student s : students) {
            tvResult.append("\n");
            tvResult.append(s.toString());
        }
        for (People p : peoples) {
            tvResult.append("\n");
            tvResult.append(p.toString());
        }
        return students;
    }

    /**
     * 增
     * 数据不存在 则输入为默认值
     *
     * @param id
     * @param name
     */
    private void add(String id, String name) {
        DaoSession daoSession = ((MyApplication) getApplication()).getDaoSession();
        int studentNo = Integer.valueOf(id);
        People people = new People();
        Student student = new Student();
//        student.setAge(studentNo / 2);
        student.setName(name);
        student.setStudentNo(studentNo);
        student.setSchool("学校" + name);
        student.setWife("sadas" + name);
        student.setFarther(name + "dasdsa" + name);
        people.setName(name);
        people.setStudentNo(studentNo);
        people.setSchool("学校" + name);
        people.setWife("sadas" + name);
        people.setFarther(name + "dasdsa" + name);
        //注意这个添加的方式  如果记录已存在 并且时unique  会出异常  SQLiteConstraintException
        try {
            daoSession.insert(student);
            daoSession.insert(people);
        } catch (SQLiteConstraintException e) {
            Toast.makeText(this, "数据已存在", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDbContent() {
        DaoSession daoSession = ((MyApplication) getApplication()).getDaoSession();
        List<Student> students = daoSession.loadAll(Student.class);
        List<People> peoples = daoSession.loadAll(People.class);
        tvDbContent.setText("");
        for (Student s : students) {
            Log.i(TAG, "showDbContent: " + s.toString());

            tvDbContent.append("\n");
            tvDbContent.append(s.toString());
        }
        for (People p : peoples) {
            Log.i(TAG, "showDbContent: " + p.toString());

            tvDbContent.append("\n");
            tvDbContent.append(p.toString());
        }

    }
}
