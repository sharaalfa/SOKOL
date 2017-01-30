/*
 * Copyright 2016-2017 Sokol Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.khasang.sokol.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.logging.Logger;

public class CreateTable {
    private static final Logger log = Logger.getLogger("CreateTable");
    final String QUERY_CREATE_ROLE =
            "CREATE TABLE Role(\n" +
                    "id integer,\n" +
                    "roleName varchar(60),\n" +
                    "PRIMARY KEY(id)\n" +
                    ");";

    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTable() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS Role");
            jdbcTemplate.execute(QUERY_CREATE_ROLE);
            log.info("table successfully created");
            return "table successfully created";
        } catch (Exception e) {
            log.warning(e.getMessage());
            return e.toString();
        }
    }
}
