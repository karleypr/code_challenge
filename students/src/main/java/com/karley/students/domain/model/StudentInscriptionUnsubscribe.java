package com.karley.students.domain.model;

import lombok.*;

import java.util.List;

/**
 * Modelo StudentInscriptionUnsubscribe
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentInscriptionUnsubscribe {

    /**
     * Identificador del estudiante al que
     * se desea inscribir/desinscribir en los cursos
     */
    private Integer studentId;

    /**
     * Lista de identificadores de cursos en los que
     * se desea inscribir/desinscribir a un estudiante
     */
    private List<Integer> courseIdList;
}
