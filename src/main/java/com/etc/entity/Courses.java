package com.etc.entity;

public class Courses {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_courses.courseid
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    private Integer courseid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_courses.course
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    private String course;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_courses.period
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    private Integer period;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_courses.studentname
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    private String studentname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_courses.parentname
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    private String parentname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_courses.teaname
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    private String teaname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_courses.date
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    private String date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_courses.classtime
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    private String classtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_courses.datetime
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    private Long datetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_courses.courseid
     *
     * @return the value of t_courses.courseid
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public Integer getCourseid() {
        return courseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_courses.courseid
     *
     * @param courseid the value for t_courses.courseid
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_courses.course
     *
     * @return the value of t_courses.course
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public String getCourse() {
        return course;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_courses.course
     *
     * @param course the value for t_courses.course
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public void setCourse(String course) {
        this.course = course == null ? null : course.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_courses.period
     *
     * @return the value of t_courses.period
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_courses.period
     *
     * @param period the value for t_courses.period
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_courses.studentname
     *
     * @return the value of t_courses.studentname
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public String getStudentname() {
        return studentname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_courses.studentname
     *
     * @param studentname the value for t_courses.studentname
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_courses.parentname
     *
     * @return the value of t_courses.parentname
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public String getParentname() {
        return parentname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_courses.parentname
     *
     * @param parentname the value for t_courses.parentname
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public void setParentname(String parentname) {
        this.parentname = parentname == null ? null : parentname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_courses.teaname
     *
     * @return the value of t_courses.teaname
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public String getTeaname() {
        return teaname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_courses.teaname
     *
     * @param teaname the value for t_courses.teaname
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public void setTeaname(String teaname) {
        this.teaname = teaname == null ? null : teaname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_courses.date
     *
     * @return the value of t_courses.date
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public String getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_courses.date
     *
     * @param date the value for t_courses.date
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_courses.classtime
     *
     * @return the value of t_courses.classtime
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public String getClasstime() {
        return classtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_courses.classtime
     *
     * @param classtime the value for t_courses.classtime
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public void setClasstime(String classtime) {
        this.classtime = classtime == null ? null : classtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_courses.datetime
     *
     * @return the value of t_courses.datetime
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public Long getDatetime() {
        return datetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_courses.datetime
     *
     * @param datetime the value for t_courses.datetime
     *
     * @mbg.generated Sat Oct 06 09:52:23 CST 2018
     */
    public void setDatetime(Long datetime) {
        this.datetime = datetime;
    }

    public Courses() {
    }

    public Courses(Integer courseid, String course, Integer period, String studentname, String parentname, String teaname, String date, String classtime, Long datetime) {
        this.courseid = courseid;
        this.course = course;
        this.period = period;
        this.studentname = studentname;
        this.parentname = parentname;
        this.teaname = teaname;
        this.date = date;
        this.classtime = classtime;
        this.datetime = datetime;
    }

    public Courses(String course, Integer period, String studentname, String parentname, String teaname, String date, String classtime, Long datetime) {
        this.course = course;
        this.period = period;
        this.studentname = studentname;
        this.parentname = parentname;
        this.teaname = teaname;
        this.date = date;
        this.classtime = classtime;
        this.datetime = datetime;
    }

    public Courses(String course, Integer period, String studentname, String date, String classtime,String teaname) {
        this.course = course;
        this.period = period;
        this.studentname = studentname;
        this.date = date;
        this.classtime = classtime;
        this.teaname = teaname;
    }

    public Courses(String course, Integer period, String studentname, String teaname, String classtime) {
        this.course = course;
        this.period = period;
        this.studentname = studentname;
        this.teaname = teaname;
        this.classtime = classtime;
    }
    public Courses(String course,  String studentname, String date,Integer period, String classtime) {
        this.course = course;
        this.studentname = studentname;
        this.date = date;
        this.period = period;
        this.classtime = classtime;
    }

    public Courses(String course, Integer period, String studentname, String parentname, String teaname, String date, String classtime) {
        this.course = course;
        this.period = period;
        this.studentname = studentname;
        this.parentname = parentname;
        this.teaname = teaname;
        this.date = date;
        this.classtime = classtime;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseid=" + courseid +
                ", course='" + course + '\'' +
                ", period=" + period +
                ", studentname='" + studentname + '\'' +
                ", parentname='" + parentname + '\'' +
                ", teaname='" + teaname + '\'' +
                ", date='" + date + '\'' +
                ", classtime='" + classtime + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}