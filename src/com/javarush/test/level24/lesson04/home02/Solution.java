package com.javarush.test.level24.lesson04.home02;

/* Black box
1. Восстановите логику метода someAction для поля solutionAction.
2. Пример вывода смотрите коментарием к методу main.
3. Подсказка: метод someAction анонимного класса поля solutionAction должен вызвать метод сабкласса FirstClass,
если param > 0, иначе вызвать метод сабкласса SecondClass
4. Свои строки создавать нельзя.
5. Классы Action, FirstClass, SecondClass менять нельзя.
*/
public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    /*private Action solutionAction = new Action() {
        //!!!!! Changes can be here
        //!!!!! Изменения могут быть тут
        private SecondClass secondClass=new SecondClass();

        public void someAction() {
            //!!!!! All changes have to be here
            //!!!!! Все изменения должны быть только тут
            secondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM="Specific action for anonymous SecondClass, param = ";

            while (0<param) {
                System.out.println(param--);
            }

            if (0<param){
                new FirstClass(){
                    @Override
                    public Action getDependantAction() {
                        return new Action() {
                            @Override
                            public void someAction() {
                                //
                            }
                        };
                    }
                }.someAction();
                secondClass.someAction();
                System.out.println(secondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM + param);
            }else {
                secondClass.someAction();
                System.out.println(secondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM+param);
            }
        }
    };*/

    private Action solutionAction = new Action() {
        //!!!!! Changes can be here
        //!!!!! Изменения могут быть тут

        public void someAction() {
            if (param>0)
            {
                while (param>0)
                    System.out.println(param--);
                new FirstClass(){
                    @Override
                    public Action getDependantAction()
                    {
                        return new Action()
                        {
                            @Override
                            public void someAction()
                            {

                            }
                        };
                    }
                }.someAction();

                someAction();


            }
            else
            {
                new SecondClass().someAction();

                System.out.println(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM + param);


            }
            //!!!!! All changes have to be here
            //!!!!! Все изменения должны быть только тут
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}
