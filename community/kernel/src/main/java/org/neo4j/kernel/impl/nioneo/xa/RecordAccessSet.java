/**
 * Copyright (c) 2002-2014 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.impl.nioneo.xa;

import java.util.Collection;

import org.neo4j.kernel.impl.nioneo.store.DynamicRecord;
import org.neo4j.kernel.impl.nioneo.store.LabelTokenRecord;
import org.neo4j.kernel.impl.nioneo.store.NodeRecord;
import org.neo4j.kernel.impl.nioneo.store.PrimitiveRecord;
import org.neo4j.kernel.impl.nioneo.store.PropertyKeyTokenRecord;
import org.neo4j.kernel.impl.nioneo.store.PropertyRecord;
import org.neo4j.kernel.impl.nioneo.store.RelationshipGroupRecord;
import org.neo4j.kernel.impl.nioneo.store.RelationshipRecord;
import org.neo4j.kernel.impl.nioneo.store.RelationshipTypeTokenRecord;
import org.neo4j.kernel.impl.nioneo.store.SchemaRule;

public interface RecordAccessSet
{
    RecordAccess<Long, NodeRecord, Void> getNodeRecords();

    RecordAccess<Long, PropertyRecord, PrimitiveRecord> getPropertyRecords();

    RecordAccess<Long, RelationshipRecord, Void> getRelRecords();

    RecordAccess<Long, RelationshipGroupRecord, Integer> getRelGroupRecords();

    RecordAccess<Long, Collection<DynamicRecord>, SchemaRule> getSchemaRuleChanges();
    
    RecordAccess<Integer, PropertyKeyTokenRecord, Void> getPropertyKeyTokenChanges();

    RecordAccess<Integer, LabelTokenRecord, Void> getLabelTokenChanges();

    RecordAccess<Integer, RelationshipTypeTokenRecord, Void> getRelationshipTypeTokenChanges();

    void close();
}
